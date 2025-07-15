package com.ruoyi.common.utils;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
@Component
public class PublicIpFetcher {

    // 使用亚马逊提供的服务，因为它非常稳定且只返回纯文本的IP地址
    private static final String IP_CHECK_SERVICE_URL = "https://checkip.amazonaws.com";

    /**
     * 获取运行此代码的机器的公网IP地址。
     *
     * @return 公网IP地址字符串；如果查询失败则返回 null。
     */
    public static String getPublicIp() {
        System.out.println("正在向 " + IP_CHECK_SERVICE_URL + " 查询本机的公网IP...");
        HttpURLConnection connection = null;
        try {
            URL url = new URL(IP_CHECK_SERVICE_URL);
            connection = (HttpURLConnection) url.openConnection();

            // 设置合理的超时时间，防止程序卡死
            connection.setConnectTimeout(5000); // 5秒连接超时
            connection.setReadTimeout(5000);    // 5秒读取超时
            connection.setRequestMethod("GET");

            int statusCode = connection.getResponseCode();

            if (statusCode == HttpURLConnection.HTTP_OK) { // 检查HTTP响应码是否为 200 (OK)
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    // 读取返回内容的第一行，并去除首尾空格
                    String ip = reader.readLine().trim();
                    System.out.println("成功获取到公网IP: " + ip);
                    return ip;
                }
            } else {
                System.err.println("查询失败，HTTP 响应码: " + statusCode);
                return null;
            }

        } catch (IOException e) {
            System.err.println("获取公网IP时发生IO异常: " + e.getMessage());
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect(); // 确保关闭连接
            }
        }
    }

    public static void main(String[] args) {
        String publicIp = getPublicIp();

        if (publicIp != null) {
            System.out.println("\n本机的公网IP地址是: " + publicIp);
        } else {
            System.out.println("\n未能获取到本机的公网IP地址。");
        }
    }
}
