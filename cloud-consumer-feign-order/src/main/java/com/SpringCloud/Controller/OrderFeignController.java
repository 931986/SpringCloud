package com.SpringCloud.Controller;

import com.SpringCloud.Service.PaymentService;
import com.SpringCloud.pojo.CommonResult;
import com.SpringCloud.pojo.PayMent;
import feign.RequestLine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


@RestController
@Slf4j

//@RequestMapping(value = "/consumer")
public class OrderFeignController {
    @Value("${server.port}")
    private String serverPort;

//    @Qualifier("PaymentImple")
//@Qualifier("PaymentService")

@Resource
    private PaymentService paymentService;

//    @RequestMapping(value = "",method = RequestMethod.GET)


@GetMapping("/consumer/payment/timeout")
public String PaymentTimeOut() throws InterruptedException{
    TimeUnit.SECONDS.sleep(3);
    return serverPort;
}



@GetMapping("/consumer/payment/get/{id}")
public  CommonResult<PayMent> GetPaymentById(@PathVariable("id") long id){
       CommonResult<PayMent> payment = paymentService.queryById(id);
        log.info("***************查询成功*********" + payment);

    return payment;

    }



}
