package com.restaurant.Restaurant.controller;

import com.restaurant.Restaurant.models.dto.ClientDTO;
import com.restaurant.Restaurant.models.dto.OrderDTO;
import com.restaurant.Restaurant.service.orders.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    @Autowired
    OrderServiceImpl service;
    @PostMapping
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO){
        return service.createOrder(orderDTO);
    }

    @PatchMapping(path = "/{uuid}/delivered/{timestamp}")
    public OrderDTO updateOrderDelivered(OrderDTO dto, LocalDateTime time){
        return service.updateOrderDelivered( dto, time);
    }
}
