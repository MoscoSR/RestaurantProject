package com.restaurant.Restaurant.service.products;

import com.restaurant.Restaurant.entity.ProductEntity;
import com.restaurant.Restaurant.mapper.ProductEntityToDtoMapper;
import com.restaurant.Restaurant.models.dto.ProductDTO;
import com.restaurant.Restaurant.repository.IProductRepositoryJPA;
import com.restaurant.Restaurant.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements  IProductService{

    private ProductRepository repository;
    @Autowired
    private IProductRepositoryJPA repositoryJPA;


    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }



    @Override
    public String getAllProducts() {
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

    public ProductDTO getById(Long id){
        ProductEntityToDtoMapper mapper= new ProductEntityToDtoMapper();
        return  mapper.convert( repository.findProductById(id));
    }
}
