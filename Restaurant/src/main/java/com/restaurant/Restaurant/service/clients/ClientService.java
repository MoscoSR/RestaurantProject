package com.restaurant.Restaurant.service.clients;
import com.restaurant.Restaurant.entity.ClientEntity;
import com.restaurant.Restaurant.models.dto.ClientDTO;
import com.restaurant.Restaurant.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientEntity getClienteById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }
    public void createClient(ClientEntity client){
         clientRepository.save(client);
    }
    public ClientEntity updateCliente(ClientDTO updatedClient) throws EntityNotFoundException {
        ClientEntity existingClient = clientRepository.findById(updatedClient.getId()).orElseThrow(() -> new EntityNotFoundException("Client with ID " + updatedClient.getId() + " not found"));
        return clientRepository.save(existingClient);
    }
    public void deleteCliente(Long id){
         clientRepository.deleteById(id);
    }
}
