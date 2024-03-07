package com.restaurant.Restaurant.models.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder // Lombok annotation to create a builder for the class, avoiding the creation of the constructor
public class OrderDTO {
    private Long id;
    private String uuid;
    private LocalDate creationDateTime;
    private String clientDocument;
    private String productUuid;
    private Integer quantity;
    private String extraInformation;
    private Double subTotal;
    private Double tax;
    private Double grandTotal;
    private Boolean delivered;
    private LocalDate deliveredDateTime;
}
