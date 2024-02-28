package com.restaurant.Restaurant.repository;


import com.restaurant.Restaurant.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
