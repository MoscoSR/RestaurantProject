package com.restaurant.Restaurant.controller;

import com.restaurant.Restaurant.service.orders.OrderServiceImpl;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor // Lombok will generate a constructor with all the fields of the class
@RequestMapping(path = "/orders")
public class OrderController {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(OrderController.class); // Logger to display information

    @Autowired
    OrderServiceImpl service;
    @PostMapping
    public String createOrder(){
        return null;
    }

    @PatchMapping(path = "/{uuid}/delivered/{timestamp}")
    public String updateOrderDelivered(){
        return service.updateOrderDelivered();
    }
}
