package com.restaurant.Restaurant.models.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class OrderDTO {

    private int id;

    private String uuid;

    private LocalDateTime creationDateTime;

    private String clientDocument;

    private String productUuid;

    private int quantity;

    private String extraInformation;

    private double subTotal;

    private double tax;

    private double grandTotal;

    private boolean delivered;

    private LocalDateTime deliveredDate;
}
