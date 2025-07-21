package com.ruoyi.framework.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

/**
 * 文件上传配置
 * 
 * @author ruoyi
 */
@Configuration
public class MultipartConfig
{
    /**
     * 文件上传配置
     */
    @Bean
    public MultipartConfigElement multipartConfigElement()
    {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 单个文件最大
        factory.setMaxFileSize(DataSize.ofMegabytes(999));
        // 设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.ofMegabytes(10240));
        return factory.createMultipartConfig();
    }
}