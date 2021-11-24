package com.SpringCloud.pojo.Order.Model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {
    private String orderIdCard;
    private Double orderPrice;
    private  Integer orderCount;
}
