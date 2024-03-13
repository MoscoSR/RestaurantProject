package com.restaurant.Restaurant.service.products;

import com.restaurant.Restaurant.entity.ProductEntity;
import com.restaurant.Restaurant.exception.impl.DataAlreadyExistsException;
import com.restaurant.Restaurant.exception.impl.FantasyNameExistsException;
import com.restaurant.Restaurant.exception.impl.ProductNotFoundException;
import com.restaurant.Restaurant.mapper.ProductMapper;
import com.restaurant.Restaurant.models.dto.ProductDTO;
import com.restaurant.Restaurant.repository.IProductRepositoryJPA;
import com.restaurant.Restaurant.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service

public class ProductService {

    @Autowired
    private final IProductRepositoryJPA productRepository;
    @Autowired
    private final ProductMapper mapper;
    @Autowired
    private final ProductValidator validator;
    public ProductService(IProductRepositoryJPA productRepository, ProductMapper mapper, ProductValidator validator) {
        this.productRepository = productRepository;
        this.mapper = mapper;
        this.validator = validator;
    }

    public ProductDTO getProductByUuid(String uuid) {
        validator.validateUuid(uuid);
        if (productRepository.findByUuid(uuid)==null){
            throw new ProductNotFoundException("Producto no encontrado");
        }
        return  mapper.EntityToDTO(productRepository.findByUuid(uuid));
    }
    public ProductDTO createProduct(ProductDTO product){
        validator.validateProductDto(product);
        ProductEntity productEntity= mapper.DTOToEntity(product);
        if (productRepository.existsByfantasyName(productEntity.getFantasyName())){
            throw new FantasyNameExistsException("Producto con nombre fantasia ya existe");
        }
        return mapper.EntityToDTO(productRepository.save(productEntity));

    }
    public void updateProduct(ProductDTO product) {
        validator.validateUuid(product.getUuid());
        ProductEntity productExist= productRepository.findByUuid(product.getUuid());
        if (productExist==null){
          throw  new ProductNotFoundException("Product con uuid " + product.getUuid() + " no existe");
        }
        validator.validateProductDto(product);
        validator.productCompare(product,mapper.EntityToDTO(productExist));
        if (productRepository.existsByfantasyName(product.getFantasyName()) && validator.productExistFantasyName(productExist.getFantasyName(),product.getFantasyName())){
            throw new FantasyNameExistsException("Producto con nombre fantasia ya existe");
        }
        productExist.setFantasyName(product.getFantasyName().toUpperCase());
        productExist.setCategory(product.getCategory());
        productExist.setPrice(product.getPrice());
        productExist.setDescription(product.getDescription());
        productExist.setAvailable(product.getAvailable());
        productRepository.save(productExist);

    }

    public void deleteProduct(String uuid){
        validator.validateUuid(uuid);
        ProductEntity productExist= productRepository.findByUuid(uuid);
        if (productExist==null){
            throw  new ProductNotFoundException("Product with Uuid " + uuid + " not found");
        }
        productRepository.delete(productExist);

    }
}
