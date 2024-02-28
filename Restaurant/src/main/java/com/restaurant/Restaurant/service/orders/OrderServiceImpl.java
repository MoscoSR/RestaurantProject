package com.restaurant.Restaurant.service.orders;

import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService{
    @Override
    public String createOrder() {
        return "Your order is on the way!";
    }

    @Override
    public String updateOrderDelivered() {
        return "Order delivered!";
    }
}
