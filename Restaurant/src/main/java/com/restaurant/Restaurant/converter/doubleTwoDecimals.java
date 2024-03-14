package com.restaurant.Restaurant.converter;

import java.text.DecimalFormat;

public class doubleTwoDecimals {
    public static double convert(double value){
        DecimalFormat df = new DecimalFormat("#.##");
        return Math.round(value * 100.0) / 100.0;
    }
}
