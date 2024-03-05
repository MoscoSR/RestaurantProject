package com.restaurant.Restaurant.service.clients;
import com.restaurant.Restaurant.entity.ClientEntity;
import com.restaurant.Restaurant.mapper.ClientEntityToDtoMapper;
import com.restaurant.Restaurant.models.dto.ClientDTO;
import com.restaurant.Restaurant.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService  implements IClientService{

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientEntityToDtoMapper mapper;

    @Override
    public List<ClientDTO> getClients() {
        List<ClientEntity> clients = clientRepository.findAll();
        return clients.stream()
                .map(mapper::convert)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO getClient(Long id) {
        ClientEntity clientEntity = clientRepository.findById(id).orElse(null);
        return mapper.convert(clientEntity);
    }

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        ClientEntity  clientEntity = new ClientEntity();
        clientEntity.setName(clientDTO.getName());
        clientEntity.setDocument(clientDTO.getDocument());
        clientEntity.setEmail(clientDTO.getEmail());
        clientEntity.setPhone(clientDTO.getPhone());
        clientEntity.setDeliveryAddress(clientDTO.getDeliveryAddress());
        clientRepository.save(clientEntity);
        return mapper.convert(clientEntity);
    }

    @Override
    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        ClientEntity clientEntity = clientRepository.findById(id).orElse(null);
        clientEntity.setName(clientDTO.getName());
        clientEntity.setDocument(clientDTO.getDocument());
        clientEntity.setEmail(clientDTO.getEmail());
        clientEntity.setPhone(clientDTO.getPhone());
        clientEntity.setDeliveryAddress(clientDTO.getDeliveryAddress());
        clientRepository.save(clientEntity);
        return mapper.convert(clientEntity);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
