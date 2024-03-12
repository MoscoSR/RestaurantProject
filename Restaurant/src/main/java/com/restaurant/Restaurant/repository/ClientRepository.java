package com.restaurant.Restaurant.repository;


import com.restaurant.Restaurant.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    ClientEntity findByDocument(String document);
    ClientEntity deleteByDocument(String document);

}
