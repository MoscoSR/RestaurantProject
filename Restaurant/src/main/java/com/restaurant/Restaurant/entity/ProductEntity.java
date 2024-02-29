package com.restaurant.Restaurant.entity;
import lombok.*;

import java.util.*;


import jakarta.persistence.*;

import java.util.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

    public enum Category{
        HAMBURGERS_AND_HOTDOGS, CHICKEN, FISH, MEATS, DESSERTS, VEGAN_FOOD, KIDS_MEALS
    }

    @Id
    private Long id;

    @Column(name = "product_uuid", nullable = false)
    private UUID uuid;

    @Column(name = "name", nullable = false)
    private String fantasyName;

    @Column(name = "category", nullable = false)
    private Category category;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "available", nullable = false)
    private boolean available;
}
