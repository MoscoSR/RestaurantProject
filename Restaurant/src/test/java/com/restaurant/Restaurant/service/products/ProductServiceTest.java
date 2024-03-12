package com.restaurant.Restaurant.service.products;

import com.restaurant.Restaurant.entity.ProductEntity;
import com.restaurant.Restaurant.mapper.ProductMapper;
import com.restaurant.Restaurant.models.dto.ProductDTO;
import com.restaurant.Restaurant.repository.IProductRepositoryJPA;
import com.restaurant.Restaurant.validator.ProductValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    private ProductDTO productDTO;
    private ProductEntity productEntity;
    @InjectMocks
    private ProductService productService;
    @Mock
    private  IProductRepositoryJPA productRepository;
    @Mock
    private  ProductMapper mapper;
    @Mock
    private  ProductValidator validator;

    @BeforeEach
    public void setUp(){
        productEntity = productEntity.builder()
                .fantasyName("Hamburger With Chess")
                .category(ProductEntity.Category.MEATS)
                .description("Hamburger chess with potatoes")
                .build();

        productDTO = productDTO.builder()
                .uuid(UUID.randomUUID().toString())
                .fantasyName("Hamburger With Chess")
                .category(ProductEntity.Category.MEATS)
                .description("Hamburger with chess extra")
                .price(2000D)
                .available(true)
                .build();
    }
    @Test
    void shouldSaveProductSuccessfully(){
        Mockito.doNothing().when(validator).validateProductDto(productDTO);
        Mockito.when(mapper.DTOToEntity(productDTO)).thenReturn(productEntity);
        Mockito.when(productRepository.existsByfantasyName(productDTO.getFantasyName())).thenReturn(Boolean.FALSE);
        Mockito.when(productRepository.save(productEntity)).thenReturn(productEntity);
        var response= productService.createProduct(productDTO);
    }

}