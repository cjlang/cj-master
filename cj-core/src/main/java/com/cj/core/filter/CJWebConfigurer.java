package com.cj.core.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class CJWebConfigurer implements WebMvcConfigurer {

    @Value("${cj.filter.excludePathPatterns}")
    private List<String> cjfilter;

    @Autowired
    CJInterceptor cjInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        cjfilter.add("/");
        cjfilter.add("/doc.html");
        cjfilter.add("/sys/login");
        cjfilter.add("/unlogin");
        cjfilter.add("/sys/success");
        cjfilter.add("/sys/unauth");
        cjfilter.add("/webjars/**");
        cjfilter.add("/swagger-resources/**");
        cjfilter.add("/v2/**");
        registry.addInterceptor(cjInterceptor)
                .addPathPatterns("/**")//拦截所有地址
                .excludePathPatterns(cjfilter);//不拦截的
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }
}