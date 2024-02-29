package com.restaurant.Restaurant.mapper;

import com.restaurant.Restaurant.entity.ClientEntity;
import com.restaurant.Restaurant.models.dto.ClientDTO;

public class ClientEntityToDtoMapper {

    public ClientDTO map(ClientEntity clientEntity){
        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setName(clientEntity.getName());
        clientDTO.setDocument(clientDTO.document);
        // mas campos

        return clientDTO;
    }
}
