package com.restaurant.Restaurant.mapper;

import com.restaurant.Restaurant.entity.ClientEntity;
import com.restaurant.Restaurant.models.dto.ClientDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientEntityToDtoMapper implements Converter<ClientEntity, ClientDTO> {
    @Override
    public ClientDTO convert(ClientEntity clientEntity) {
        return ClientDTO.builder()
                .name(clientEntity.getName())
                .document(clientEntity.getDocument())
                .email(clientEntity.getEmail())
                .phone(clientEntity.getPhone())
                .deliveryAddress(clientEntity.getDeliveryAddress())
                .build();
    }
    public List<Long>getClients(List<ClientEntity> entityList) {
        return entityList.stream()
                .map(ClientEntity::getId)
                .collect(Collectors.toList());
    }
}
