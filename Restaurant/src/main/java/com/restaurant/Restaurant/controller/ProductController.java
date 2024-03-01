package com.restaurant.Restaurant.controller;

import com.restaurant.Restaurant.entity.ProductEntity;
import com.restaurant.Restaurant.models.dto.ProductDTO;
import com.restaurant.Restaurant.service.products.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    ProductServiceImpl service;

//    @GetMapping(path = "/{uuid}")
//    public String getProduct (){
//        return  service.getProduct();
//    }

    @PostMapping
    public String createProduct (){
        return  service.createProduct();
    }

    @PutMapping(path = "/{uuid}")
    public String updateProduct (){
        return  service.updateProduct();
    }


    @DeleteMapping(path = "/{uuid}")
    public String deleteProduct (){
        return  service.deleteProduct();
    }

    @GetMapping(path = "/{id}")
    public ProductDTO getProductById (@PathVariable Long id){
        return service.getById(id);
    }

}
