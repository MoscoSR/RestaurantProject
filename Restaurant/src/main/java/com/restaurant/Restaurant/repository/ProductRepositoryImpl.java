package com.restaurant.Restaurant.repository;

import com.restaurant.Restaurant.entity.ProductEntity;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

    List<ProductEntity> productEntityList = null;

    @Override
    public ProductEntity findProductById(Long id){
        return productEntityList.stream().filter( p -> Objects.equals( p.getId(), id)).findFirst().orElse(null);
    }

    @PostConstruct
    public void init(){
        productEntityList = List.of(
                ProductEntity.builder()
                        .id(1L)
                        .uuid(UUID.randomUUID())
                        .fantasyName("Pizza")
                        .category(ProductEntity.Category.MEATS)
                        .description("Pizza with meats")
                        .price(12000)
                        .available(true)
                        .build(),

                ProductEntity.builder()
                        .id(2L)
                        .uuid(UUID.randomUUID())
                        .fantasyName("Hot dog")
                        .category(ProductEntity.Category.HAMBURGERS_AND_HOTDOGS)
                        .description("Mexican Hotdog")
                        .price(9000)
                        .available(true)
                        .build(),

                ProductEntity.builder()
                        .id(3L)
                        .uuid(UUID.randomUUID())
                        .fantasyName("Chicken")
                        .category(ProductEntity.Category.CHICKEN)
                        .description("Chicken")
                        .price(15000)
                        .available(true)
                        .build()
        );
    }
}
