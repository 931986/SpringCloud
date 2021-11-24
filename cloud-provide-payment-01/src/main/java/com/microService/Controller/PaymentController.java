package com.microService.Controller;


import com.SpringCloud.pojo.*;


import com.microService.Service.PaymentService;
//import com.netflix.discovery.DiscoveryClient;
import com.microService.Service.hystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/*
 * 提供restful服务  供其他服务调用
 *
 * */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody PayMent dept) {
        int i = paymentService.create(dept);
        log.info("***************插入成功*******" + i);
        if (i > 0) {
            return new CommonResult(200, "插入数据库成功" + serverPort, i);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping("/payment/get/{id}")

    public CommonResult queryById(@PathVariable("id") int id) {
        PayMent payment = paymentService.queryById(id);
        log.info("***************查询成功*********" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功" + serverPort, payment);
        } else {
            return new CommonResult(444, "查询失败", null);
        }

    }


    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = (List<String>) discoveryClient.getServices();
        for (String s : services) {
            log.info("....." + s);
        }
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("Payment-provider");
        for (ServiceInstance s : serviceInstances) {
            log.info("当前sercice" + s.getServiceId() + "\t" + "host: " + s.getHost() + "\t" + s.getUri());
        }
        return this.discoveryClient;

    }
    @GetMapping("/payment/timeout")
    public String PaymentFeignTimeOut() throws InterruptedException{
        return paymentService.PaymentFeignTimeOut();
    }
    @Autowired
    private hystrixService hystrixservice;
    @GetMapping("/payment/hystrix/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result =hystrixservice.paymentInfo_OK(id) ;
        log.info("*******************result:" + result);
        return result;
    }
    @HystrixCommand(fallbackMethod = "getHystrixNews")
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Integer id) {
        String result =hystrixservice.paymentInfo_TimeOut(id) ;
        log.info("*******************result:" + result);
        return result;
    }
    public String getHystrixNews(@PathVariable("id") Integer id) {

        return "当前请求用户过多，请稍后重试";
    }





}