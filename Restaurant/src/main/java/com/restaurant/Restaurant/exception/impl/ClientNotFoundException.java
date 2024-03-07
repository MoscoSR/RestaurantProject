package com.restaurant.Restaurant.exception.impl;

public class ClientNotFoundException extends RuntimeException{

    public ClientNotFoundException (String message)
    {
        super(message);
    }
}
