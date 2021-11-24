package com.microService.Service;


import com.SpringCloud.pojo.PayMent;

import javax.websocket.server.PathParam;

public interface PaymentService  {
    int create(PayMent payMent);
    PayMent queryById(@PathParam("id")long id);
}
