package com.restaurant.Restaurant.controller;

import com.restaurant.Restaurant.service.orders.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    @Autowired
    OrderServiceImpl service;
    @PostMapping
    public String createOrder(){
        return service.createOrder();
    }

    @PatchMapping(path = "/{uuid}/delivered/{timestamp}")
    public String updateOrderDelivered(){
        return service.updateOrderDelivered();
    }
}
