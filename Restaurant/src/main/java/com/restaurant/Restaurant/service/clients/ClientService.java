package com.restaurant.Restaurant.service.clients;
import com.restaurant.Restaurant.models.Client;
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

    public Client getClienteById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }
    public void createClient(Client client){
         clientRepository.save(client);
    }
    public Client updateCliente(ClientDTO updatedClient) throws EntityNotFoundException {
        Client existingClient = clientRepository.findById(updatedClient.getId()).orElseThrow(() -> new EntityNotFoundException("Client with ID " + updatedClient.getId() + " not found"));
        return clientRepository.save(existingClient);
    }
    public void deleteCliente(Long id){
         clientRepository.deleteById(id);
    }
}
