package com.restaurant.Restaurant.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "client")
@Data
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", nullable = false)
    public Long id;

    @Column(name = "document", nullable = false)
    public String document;

    @Column(name = "name", nullable = false)
    public String name;

    @Column(name = "email")
    public String email;

    @Column(name = "phone")
    public String phone;

    @Column(name = "deliveryAddress")
    public String deliveryAddress;

}
