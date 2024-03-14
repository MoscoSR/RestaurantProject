package com.restaurant.Restaurant.controller;

import com.restaurant.Restaurant.models.dto.OrderDTO;
import com.restaurant.Restaurant.service.orders.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

    private OrderDTO orderDTO;

    @InjectMocks
    private OrderController orderController;
    @Mock
    private OrderServiceImpl service;

    @BeforeEach
    public void setUp() {
        orderDTO = OrderDTO.builder()
                .clientDocument("CC-12345")
                .productUuid("256309c6-5b24-499e-9ccb-6e69b781690a")
                .quantity(2)
                .extraInformation("Hamburguer with french fries")
                .build();
    }

    @Test
    void shouldReturnResponseCreateOrder() {
        Mockito.when(service.createOrder(orderDTO)).thenReturn(orderDTO);
        var response = orderController.createOrder(orderDTO);
        verify(service, times(1)).createOrder(orderDTO);
        assertEquals(ResponseEntity.ok(orderDTO), response);
    }

    @Test
    void shouldReturnResponseOrderDelivered() {
        var uuid = "256309c6-5b24-499e-9ccb-6e69b781690a";
        var timestamp = LocalDateTime.parse("2021-10-10T10:00:00");
        Mockito.when(service.updateOrderDeliveredByUuid(uuid, timestamp, orderDTO)).thenReturn(orderDTO);
        var response = orderController.updateOrderDelivered(uuid, timestamp, orderDTO);
        verify(service, times(1)).updateOrderDeliveredByUuid(uuid, timestamp, orderDTO);
        assertEquals(ResponseEntity.ok(orderDTO), response);
    }
}