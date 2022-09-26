package com.cj.dc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application{
    @Autowired
    private AutowireCapableBeanFactory beanFactory;
    @Autowired
    DefaultListableBeanFactory defaultListableBeanFactory;


    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}