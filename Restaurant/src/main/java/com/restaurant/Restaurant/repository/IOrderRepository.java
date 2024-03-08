package com.restaurant.Restaurant.repository;

import com.restaurant.Restaurant.entity.OrderEntity;

public interface IOrderRepository {

    OrderEntity findByUuid(String uuid);

}
