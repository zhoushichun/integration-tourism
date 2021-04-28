package com.ifm.config;

import com.ifm.comment.config.AsyncTaskProperties;
import com.ifm.comment.config.FileProperties;
import com.ifm.comment.config.LoginProperties;
import com.ifm.comment.config.SecurityProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @apiNote 配置文件转换Pojo类的 统一配置 类
 * @author: liaojinlong
 * @date: 2020/6/10 19:04
 */
@Configuration
public class ConfigBeanConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "login", ignoreUnknownFields = true)
    public LoginProperties loginProperties() {
        return new LoginProperties();
    }


    @Bean
    @ConfigurationProperties(prefix = "jwt", ignoreUnknownFields = true)
    public SecurityProperties securityProperties() {
        return new SecurityProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "file", ignoreUnknownFields = true)
    public FileProperties fileProperties() {
        return new FileProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "pool", ignoreUnknownFields = true)
    public AsyncTaskProperties asyncTaskProperties() {
        return new AsyncTaskProperties();
    }
}
