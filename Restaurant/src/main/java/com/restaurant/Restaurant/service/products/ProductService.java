package com.restaurant.Restaurant.service.products;

import com.restaurant.Restaurant.entity.ProductEntity;
import com.restaurant.Restaurant.mapper.ProductMapper;
import com.restaurant.Restaurant.models.dto.ProductDTO;
import com.restaurant.Restaurant.repository.IProductRepositoryJPA;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service

public class ProductService {

    @Autowired
    private final IProductRepositoryJPA productRepository;
    @Autowired
    ProductMapper mapper;


    public ProductService(IProductRepositoryJPA productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO getProductByUuid(String uuid) {
        return  mapper.EntityToDTO(productRepository.findByUuid(uuid));
    }
    public ProductDTO createProduct(ProductDTO product){

        ProductEntity productEntity= mapper.DTOToEntity(product);
        if (productRepository.existsByfantasyName(productEntity.getFantasyName())){
            throw new IllegalArgumentException("Producto con nombre fantasia ya existe");
        }else {
            return mapper.EntityToDTO(productRepository.save(productEntity));
        }
    }
    public void updateProduct(ProductDTO product) throws EntityNotFoundException {
        ProductEntity productExist= productRepository.findByUuid(product.getUuid());
        if (productExist==null){
          throw  new EntityNotFoundException("Product with ID " + product.getUuid() + " not found");
        }else {
            productExist.setFantasyName(product.getFantasyName().toUpperCase());
            productExist.setCategory(product.getCategory());
            productExist.setPrice(product.getPrice());
            productExist.setAvailable(product.isAvailable());
            productRepository.save(productExist);
        }
    }

    public void deleteProduct(String uuid)throws EntityNotFoundException{
        ProductEntity productExist= productRepository.findByUuid(uuid);
        if (productExist==null){
            throw  new EntityNotFoundException("Product with ID " + uuid + " not found");
        }else {
            productRepository.delete(productExist);
        }
    }
}
