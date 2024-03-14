package com.restaurant.Restaurant.models.dto;

import com.restaurant.Restaurant.entity.ClientEntity;
import com.restaurant.Restaurant.entity.ProductEntity;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder // Lombok annotation to create a builder for the class, avoiding the creation of the constructor
public class OrderDTO {
    private String uuid;
    private String creationDateTime;
    private String clientDocument;
    private String productUuid;
    private Integer quantity;
    private String extraInformation;
    private Double subTotal;
    private Double tax;
    private Double grandTotal;
    private Boolean delivered;
    private String deliveredDate;
}
