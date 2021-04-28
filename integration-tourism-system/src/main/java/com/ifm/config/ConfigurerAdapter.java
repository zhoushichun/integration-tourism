package com.ifm.config;

import com.ifm.comment.config.FileProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 *  文件图片映射类
 *
 */

@Configuration
@EnableWebMvc
public class ConfigurerAdapter implements WebMvcConfigurer {


    @Autowired
    FileProperties properties;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String echoUtl = "file:" + properties.getEcho().replace("\\","/");
        String pathUtl = "file:" + properties.getPath().replace("\\","/");
        registry.addResourceHandler("/echo/**").addResourceLocations(echoUtl).setCachePeriod(0);
        registry.addResourceHandler("/file/**").addResourceLocations(pathUtl).setCachePeriod(0);
        registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/").setCachePeriod(0);
    }
}
