package com.restaurant.Restaurant.service.products;

import com.restaurant.Restaurant.entity.ProductEntity;
import com.restaurant.Restaurant.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements  IProductService{

    private ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public String getProduct() {
        return "Product created";
    }

    @Override
    public String createProduct() {
        return "product created";
    }

    @Override
    public String updateProduct() {
        return "Product updated";
    }

    @Override
    public String deleteProduct() {
        return "product deleted";
    }

    public ProductEntity getById(Long id){
        return repository.findProductById(id);
    }
}
