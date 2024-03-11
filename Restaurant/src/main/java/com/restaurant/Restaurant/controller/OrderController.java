package com.restaurant.Restaurant.controller;

import com.restaurant.Restaurant.models.dto.OrderDTO;
import com.restaurant.Restaurant.models.dto.errorDto.OrderErrorDTO;
import com.restaurant.Restaurant.service.orders.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    @Autowired
    OrderServiceImpl service;
    @PostMapping("/newOrders")
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

    @PutMapping(path = "/{uuid}/delivered/{timestamp}")
    public ResponseEntity<?> updateOrderDelivered(@PathVariable Long uuid, @PathVariable LocalDateTime timestamp, @RequestBody OrderDTO orderDTO){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.service.updateOrderDelivered(uuid, timestamp, orderDTO));
        }catch (Exception e){
            OrderErrorDTO orderErrorDTO = new OrderErrorDTO();
            orderErrorDTO.setMessage(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(orderErrorDTO.getMessage());
        }
    }
}