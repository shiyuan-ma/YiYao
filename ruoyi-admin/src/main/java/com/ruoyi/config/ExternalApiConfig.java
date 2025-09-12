package com.ruoyi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 外部接口配置类
 * 
 * @author ruoyi
 */
@Configuration
public class ExternalApiConfig {
    
    /**
     * 创建RestTemplate Bean
     * 
     * @return RestTemplate
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}