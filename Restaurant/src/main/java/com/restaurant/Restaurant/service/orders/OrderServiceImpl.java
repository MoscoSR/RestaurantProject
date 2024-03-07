package com.restaurant.Restaurant.service.orders;

import com.restaurant.Restaurant.models.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService{

    @Autowired
    private IOrderService orderRepository;

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO updateOrderDelivered(String uuid, OrderDTO orderDTO) {
        return null;
    }
}
