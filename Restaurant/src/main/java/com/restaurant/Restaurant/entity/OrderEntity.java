package com.restaurant.Restaurant.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "orders")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String uuid;

    @Column(nullable = false)
    private LocalDate creationDateTime;

    @Column (nullable = false)
    private String clientDocument;

    @Column(nullable = false)
    private String productUuid;

    @Column(nullable = false)
    private Integer quantity;

    @Column(length = 511)
    private String extraInformation;

    @Column
    private Double subTotal;

    @Column
    private Double tax;

    @Column
    private Double grandTotal;

    @Column
    private Boolean delivered;

    @Column
    private LocalDate deliveredDateTime;
}
