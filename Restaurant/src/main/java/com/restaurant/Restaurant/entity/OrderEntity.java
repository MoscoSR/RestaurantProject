package com.restaurant.Restaurant.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "orders")
@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private int id;
//
//    @Column(name = "uuid", nullable = false)
//    private String uuid;
//
//    @Column(name = "creation_date_time", nullable = false)
//    private LocalDateTime creationDateTime;
//
//    @Column(name = "client_document", nullable = false)
//    private String clientDocument;
//
//    @Column(name = "product_uuid", nullable = false)
//    private String productUuid;
//
//    @Column(name = "quantity", nullable = false)
//    private int quantity;
//
//    @Column(name = "extra_information", nullable = false)
//    private String extraInformation;
//
//    @Column(name = "sub_total", nullable = false)
//    private double subTotal;
//
//    @Column(name = "tax", nullable = false)
//    private double tax;
//
//    @Column(name = "grand_total", nullable = false)
//    private double grandTotal;
//
//    @Column(name = "delivered", nullable = false)
//    private boolean delivered;
//
//    @Column(name = "delivered_date" )
//    private LocalDateTime deliveredDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String uuid;

    @Column(nullable = false)
    private LocalDateTime creationDateTime;

    @Column (nullable = false)
    private String clientDocument;

    @Column(nullable = false)
    private String productUuid;

    @Column(nullable = false)
    private Integer quantity;

    @Column(length = 511, nullable = false)
    private String extraInformation;

    @Column(nullable = false)
    private Double subTotal;

    @Column(nullable = false)
    private Double tax;

    @Column(nullable = false)
    private Double grandTotal;

    @Column
    private Boolean delivered = false;

    @Column
    private LocalDateTime deliveredDate;
}
