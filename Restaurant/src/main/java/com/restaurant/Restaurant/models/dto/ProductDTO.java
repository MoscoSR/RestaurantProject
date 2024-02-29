package com.restaurant.Restaurant.models.dto;

import com.restaurant.Restaurant.entity.ProductEntity;
import lombok.Data;
import java.util.UUID;

@Data
public class ProductDTO {

    private UUID uuid;
    private String fantasyName;
    private ProductEntity.Category category;
    private String description;
    private double price;
    private boolean available;
}
