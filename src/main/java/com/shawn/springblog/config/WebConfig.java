package com.shawn.springblog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
        .order(Ordered.HIGHEST_PRECEDENCE).addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/login")

        .excludePathPatterns("/admin");
    }
}
