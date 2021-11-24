package com.SpringCloud;



import com.SpringCloud.rule.ConfigRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//
//    @SpringBootApplication
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
  @EnableEurekaClient

        @RibbonClient(name = "Payment-provider",configuration = ConfigRule.class)
    public class OrderMain {
        public static void main(String[] args) {
            SpringApplication.run(OrderMain.class,args);
        }
    }

