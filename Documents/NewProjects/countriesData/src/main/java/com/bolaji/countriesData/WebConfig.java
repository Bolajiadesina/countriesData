package com.bolaji.countriesData;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig {
    @Bean
    WebMvcConfigurer mvcViewConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/bolaji").setViewName("bolajiPortfolio");
                // ...
            }
        };
    }
}
