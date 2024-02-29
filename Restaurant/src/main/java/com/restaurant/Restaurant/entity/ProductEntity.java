package com.restaurant.Restaurant.entity;
import java.util.*;

public class ProductEntity {

    public enum Category{
        HAMBURGERS_AND_HOTDOGS, CHICKEN, FISH, MEATS, DESSERTS, VEGAN_FOOD, KIDS_MEALS
    }

    private UUID uuid;
    private String fantasyName;
    private Category category;
    private String description;
    private double price;
    private boolean available;
}
