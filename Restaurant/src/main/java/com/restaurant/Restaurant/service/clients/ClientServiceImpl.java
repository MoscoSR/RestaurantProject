package com.restaurant.Restaurant.service.clients;

import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements IClientService {
    @Override
    public String getClients() {
        return "Andres Felipe";
    }
    @Override
    public String createClient() {
        return "Client created";
    }

    @Override
    public String updateClient() {
        return "Client updated";
    }

    @Override
    public String deleteClient() {
        return "Client deleted";
    }
}
