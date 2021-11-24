package com.SpringCloud.config;



import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContentConfig {
    @Bean
//    用户请求的时候，分布式提供了多个server,需要负载均衡
    @LoadBalanced

    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}