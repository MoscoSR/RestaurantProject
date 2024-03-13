package com.restaurant.Restaurant.repository;

import com.restaurant.Restaurant.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IOrderRepository extends JpaRepository<OrderEntity, Long> {
    Optional<OrderEntity> findByUuid(String uuid);
}

