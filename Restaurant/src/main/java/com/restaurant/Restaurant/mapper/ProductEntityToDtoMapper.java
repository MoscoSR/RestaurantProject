package com.restaurant.Restaurant.mapper;

import com.restaurant.Restaurant.entity.ProductEntity;
import com.restaurant.Restaurant.models.dto.ProductDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductEntityToDtoMapper implements Converter<ProductEntity,ProductDTO> {

    @Override
    public  ProductDTO convert(ProductEntity product){
        return  ProductDTO
                .builder()
                .uuid(product.getUuid())
                .fantasyName(product.getFantasyName())
                .description(product.getDescription())
                .category(product.getCategory())
                .price(product.getPrice())
                .available(product.isAvailable())
                .build();
    }
}
