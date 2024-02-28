package com.restaurant.Restaurant.service.products;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements  IProductService{
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
}
