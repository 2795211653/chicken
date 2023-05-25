package com.cqm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Override
protected void addResourceHandlers(ResourceHandlerRegistry registry){
    registry.addResourceHandler("/backend/**").addResourceLocations("classpath:/backed/");
    registry.addResourceHandler("/front/**").addResourceLocations("classpath:/front/");
}

}
