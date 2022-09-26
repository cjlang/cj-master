package com.cj.init;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListenerConfig {
    @Bean
    public ApplicationStartListener applicationStartListener(){
        return new ApplicationStartListener();
    }
}