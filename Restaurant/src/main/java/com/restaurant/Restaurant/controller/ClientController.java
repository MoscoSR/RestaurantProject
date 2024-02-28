package com.restaurant.Restaurant.controller;
import com.restaurant.Restaurant.models.Client;
import com.restaurant.Restaurant.models.dto.ClientDTO;
import com.restaurant.Restaurant.service.clients.ClientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private ClientService clientService;
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @GetMapping("/{document}")
    public Client getClientById(@PathVariable String document) {
        return clientService.getClienteById(Long.valueOf(document));
    }
    @PostMapping("/clients")
    public void createCliente(@RequestBody Client client) {
        clientService.createClient(client);
    }

    @PutMapping()
    public Client uppdateClient(ClientDTO clientDTO) {
        return clientService.updateCliente(clientDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.deleteCliente(id);
    }
}
