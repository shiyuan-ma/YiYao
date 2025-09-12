package com.ruoyi.common.utils.czdb;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.czdb.exception.IpFormatException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.regex.Pattern;

@Component
public class IpSearcher {

    private DbSearcher searcher;
    private Path tempFile;


    // 使用正则表达式来验证IPv4地址的格式
    private static final Pattern IPV4_PATTERN =
            Pattern.compile("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");

    @PostConstruct
    public void init() throws IOException {
        try {
            // 使用类加载器加载资源文件
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("offlineIP/cz88_public_v4.czdb");
            if (inputStream == null) {
                throw new IOException("在classpath中找不到资源文件: offlineIP/cz88_public_v4.czdb");
            }

            // 将资源流拷贝到一个临时文件
            this.tempFile = Files.createTempFile("cz88db", ".tmp");
            Files.copy(inputStream, this.tempFile, StandardCopyOption.REPLACE_EXISTING);

            // 确保程序退出时删除临时文件
            this.tempFile.toFile().deleteOnExit();

            // 使用临时文件的路径字符串创建DbSearcher实例
            this.searcher = new DbSearcher(this.tempFile.toString(), QueryType.MEMORY, "dWWs6VJ3wQlWLT18SCfBFw==");

        } catch (IOException e) {
            System.err.println("初始化IP地址库失败，请检查文件是否存在：" + e.getMessage());
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String searchIpAddress(String ip) {
        if (StringUtils.isEmpty(ip) || !IPV4_PATTERN.matcher(ip).matches()) {
            return null;
        }

        try {
            String ipInfo = searcher.search(ip);
            return ipInfo.replaceAll("\\s+", "-");
        } catch (IpFormatException | IOException e) {
            // 捕获特定异常并统一处理，避免重复代码
            throw new RuntimeException("IP地址查询失败: " + ip, e);
        }
    }
}