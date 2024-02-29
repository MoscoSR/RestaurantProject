package com.restaurant.Restaurant.repository;


import com.restaurant.Restaurant.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository {

    ProductEntity findProductById(Long id);
}
