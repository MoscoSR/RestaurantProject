package com.restaurant.Restaurant.mapper;

import com.restaurant.Restaurant.entity.OrderEntity;
import com.restaurant.Restaurant.models.dto.OrderDTO;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

@Component
public class OrderEntityToDtoMapper implements Converter<OrderEntity, OrderDTO>{
    @Override
    public OrderDTO convert(OrderEntity orderEntity) {
        return OrderDTO.builder()
                .id(orderEntity.getId())
                .uuid(orderEntity.getUuid())
                .creationDateTime(orderEntity.getCreationDateTime())
                .clientDocument(orderEntity.getClientDocument())
                .productUuid(orderEntity.getProductUuid())
                .quantity(orderEntity.getQuantity())
                .extraInformation(orderEntity.getExtraInformation())
                .subTotal(orderEntity.getSubTotal())
                .tax(orderEntity.getTax())
                .grandTotal(orderEntity.getGrandTotal())
                .delivered(orderEntity.getDelivered())
                .deliveredDateTime(orderEntity.getDeliveredDateTime())
                .build();
    }


}
