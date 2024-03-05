package com.restaurant.Restaurant.controller;

import com.restaurant.Restaurant.models.dto.ProductDTO;
import com.restaurant.Restaurant.service.products.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(path = "/{uuid}")
    public ResponseEntity<?> getProductById (@PathVariable String uuid){
        try {
            ProductDTO productDTO=productService.getProductByUuid(uuid);
            if (productDTO!=null){
                return ResponseEntity.ok(productDTO);
            }else{
                return ResponseEntity.status(404).body("Producto no encontrado");
            }
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(400).body("Formato de UUID invalido");
        }catch (Exception e){
            return ResponseEntity.status(500).body("Error general del servidor: "+e.getMessage());
        }

    }
    @PostMapping
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductDTO productDTO){
        try{
            ProductDTO product=productService.createProduct(productDTO);
            return ResponseEntity.status(201).body(product);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(409).body(e);
        }catch (Exception e){
            return ResponseEntity.status(500).body("Error general del servidor");
        }
    }





}
