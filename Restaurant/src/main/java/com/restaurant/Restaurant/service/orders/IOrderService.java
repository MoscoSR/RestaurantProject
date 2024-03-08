package com.restaurant.Restaurant.service.orders;

import com.restaurant.Restaurant.models.dto.OrderDTO;

import java.time.LocalDateTime;

public interface IOrderService {

    public OrderDTO createOrder(OrderDTO dto);

    public OrderDTO updateOrderDelivered(OrderDTO dto, LocalDateTime time);
}
