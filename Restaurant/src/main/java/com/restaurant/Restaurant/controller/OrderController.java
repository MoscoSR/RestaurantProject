package com.restaurant.Restaurant.controller;

import com.restaurant.Restaurant.models.dto.OrderDTO;
import com.restaurant.Restaurant.models.dto.errorDto.OrderErrorDTO;
import com.restaurant.Restaurant.service.orders.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    @Autowired
    OrderServiceImpl service;
    @PostMapping("/")
    public ResponseEntity<?> createOrder(@RequestBody OrderDTO orderDTO){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.service.createOrder(orderDTO));
        }catch (Exception e){
            OrderErrorDTO orderErrorDTO = new OrderErrorDTO();
            orderErrorDTO.setMessage(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(orderErrorDTO.getMessage());
        }
    }

    @PatchMapping(path = "/{uuid}/delivered/{timestamp}")
    public ResponseEntity<?> updateOrderDelivered(@PathVariable String uuid, @PathVariable LocalDateTime timestamp){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.service.updateOrderDeliveredByUuid(uuid, timestamp));
        }catch (Exception e){
            OrderErrorDTO orderErrorDTO = new OrderErrorDTO();
            orderErrorDTO.setMessage(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(orderErrorDTO.getMessage());
        }
    }
}