package com.SpringCloud.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import java.util.logging.Logger;

@Configuration
public class LoggerConfig {
    @Bean
    public Logger.Level GetLoggerLevel(){
        return Logger.Level.FULL;
    }
}
