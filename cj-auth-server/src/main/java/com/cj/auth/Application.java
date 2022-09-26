package com.cj.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.cj")
@MapperScan({"com.cj.core.auto.mapper","com.cj.core.manual.mapper","com.cj.auto.mapper","com.cj.manual.mapper"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}