package com.restaurant.Restaurant.entity;
import lombok.*;

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

    private Long id;
    private UUID uuid;
    private String fantasyName;
    private Category category;
    private String description;
    private double price;
    private boolean available;
}
