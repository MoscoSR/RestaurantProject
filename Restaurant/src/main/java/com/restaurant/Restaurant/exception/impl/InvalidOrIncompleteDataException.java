package com.restaurant.Restaurant.exception.impl;

public class InvalidOrIncompleteDataException extends  RuntimeException{

    public InvalidOrIncompleteDataException (String message){
        super(message);
    }
}
