package com.restaurant.Restaurant.service.clients;

import com.restaurant.Restaurant.models.dto.ClientDTO;

import java.util.List;

public interface IClientService {
    List<ClientDTO> getClients();

    ClientDTO getClient(Long id);
    ClientDTO createClient(ClientDTO clientDTO);
    ClientDTO updateClient(Long id, ClientDTO clientDTO);
    void deleteClient(Long id);
}

