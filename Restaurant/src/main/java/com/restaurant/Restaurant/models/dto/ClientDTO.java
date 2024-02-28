package com.restaurant.Restaurant.models.dto;

import lombok.Data;

@Data
public class ClientDTO {
    public Long id;
    public String document;
    public String name;
    public String email;
    public String phone;
    public String deliveryAddress;

}
