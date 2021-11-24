package com.SpringCloud.Service;


import com.SpringCloud.pojo.CommonResult;
import com.SpringCloud.pojo.PayMent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;


//@FeignClient(value ="Payment-provider" )
//使用feign直接与provider对接
@Component
@FeignClient(value ="Payment-provider" )
public interface PaymentService {
    @GetMapping("/create")
      int create(PayMent payMent);
//    PayMent queryById(@PathParam("id")long id);
@GetMapping("payment/get/{id}")
 CommonResult<PayMent> queryById(@RequestParam("id") long id);
    @GetMapping("payment/timeout")
    public  String paymentTimeOut() throws  InterruptedException;

//
//    @GetMapping("/payment/feign/timeout")
//    public String PaymentFeignTimeOut() throws InterruptedException;
}
