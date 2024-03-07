package com.restaurant.Restaurant.exception.impl;

public class DocumentExistsException extends RuntimeException{

    public DocumentExistsException (String message){
        super(message);
    }
}
