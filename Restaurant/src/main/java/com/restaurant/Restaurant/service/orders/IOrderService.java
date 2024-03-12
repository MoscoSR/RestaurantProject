package com.restaurant.Restaurant.service.orders;

import com.restaurant.Restaurant.models.dto.OrderDTO;
import com.restaurant.Restaurant.models.dto.ProductDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface IOrderService {
    OrderDTO createOrder(OrderDTO orderDTO);

    OrderDTO updateOrderDelivered(Long uuid, LocalDateTime timeStamp, OrderDTO orderDTO);

}