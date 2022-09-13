package com.taewan.shop.config;


import com.taewan.shop.interceptor.AdminCheckInterceptor;
import com.taewan.shop.interceptor.LoginCheckInterceptor;
import com.taewan.shop.resolver.LoginMemberArgumentResolver;
import com.taewan.shop.resolver.SessionCartArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new LoginMemberArgumentResolver());
        resolvers.add(new SessionCartArgumentResolver());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginCheckInterceptor())
                .addPathPatterns("/cart/purchase")
                .addPathPatterns("/order/**")
                .excludePathPatterns("/order/new")
                .excludePathPatterns("/order/payCheck");

        registry.addInterceptor(new AdminCheckInterceptor())
                .addPathPatterns("/admin/**");
    }
}
