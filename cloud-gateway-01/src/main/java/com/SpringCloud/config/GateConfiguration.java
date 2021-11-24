package com.SpringCloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZonedDateTime;

import javax.swing.*;

@Configuration
public class GateConfiguration {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
         ZonedDateTime time=ZonedDateTime.now();
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("patn_route_buba",r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
 routes.route("payment_route",r-> r.path("/payment/get/**").uri("lb://Payment-provider/payment/get/**")).build();
        return routes.build();
    }

}
