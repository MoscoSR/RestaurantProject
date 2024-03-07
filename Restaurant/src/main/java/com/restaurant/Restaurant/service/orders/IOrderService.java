package com.restaurant.Restaurant.service.orders;

import com.restaurant.Restaurant.models.dto.OrderDTO;

public interface IOrderService {


    OrderDTO createOrder(OrderDTO orderDTO);

    OrderDTO updateOrderDelivered(String uuid, OrderDTO orderDTO);

}
