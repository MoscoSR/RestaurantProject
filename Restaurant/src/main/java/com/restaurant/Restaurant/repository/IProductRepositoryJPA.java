package com.restaurant.Restaurant.repository;

import com.restaurant.Restaurant.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepositoryJPA extends JpaRepository<ProductEntity,Long> {
}
