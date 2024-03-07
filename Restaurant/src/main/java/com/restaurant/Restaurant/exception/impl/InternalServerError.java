package com.restaurant.Restaurant.exception.impl;

public class InternalServerError extends RuntimeException{

    public InternalServerError (String message){
        super(message);
    }
}
