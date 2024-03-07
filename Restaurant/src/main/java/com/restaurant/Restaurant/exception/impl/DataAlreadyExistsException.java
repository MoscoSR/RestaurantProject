package com.restaurant.Restaurant.exception.impl;

public class DataAlreadyExistsException extends RuntimeException{

    public DataAlreadyExistsException (String message){
        super(message);
    }
}
