package com.raiko.project.myCafe.configurations;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/templates/", "/static/", "/styles/", "/resources/")
                .addResourceLocations("classpath:/templates/", "classpath:/static/", "classpath:/css/", "classpath:/resources/");
    }
}

