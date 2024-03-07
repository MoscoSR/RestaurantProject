package com.restaurant.Restaurant.exception.impl;

public class ProductNotFoundException extends RuntimeException{

    public  ProductNotFoundException (String message){
        super(message);
    }
}
