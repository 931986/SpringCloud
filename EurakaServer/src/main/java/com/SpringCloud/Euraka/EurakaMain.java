package com.SpringCloud.Euraka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class EurakaMain {
//    package com.buba.springcloud.eureka;


        public static void main(String[] args) {
            SpringApplication.run(EurakaMain.class,args);
        }

}
