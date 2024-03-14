

package com.restaurant.Restaurant.service.clients;
import com.restaurant.Restaurant.entity.ClientEntity;
import com.restaurant.Restaurant.exception.impl.ClientNotFoundException;
import com.restaurant.Restaurant.exception.impl.DocumentExistsException;
import com.restaurant.Restaurant.exception.impl.InternalServerError;
import com.restaurant.Restaurant.mapper.ClientEntityToDtoMapper;
import com.restaurant.Restaurant.models.dto.ClientDTO;
import com.restaurant.Restaurant.repository.ClientRepository;
import com.restaurant.Restaurant.validator.ClientValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService  implements IClientService {

    private final ClientValidator clientValidator;
    private final ClientRepository clientRepository;
    private final ClientEntityToDtoMapper mapper;

    @Autowired
    public ClientService(ClientValidator clientValidator, ClientRepository clientRepository, ClientEntityToDtoMapper mapper) {
        this.clientValidator = clientValidator;
        this.clientRepository = clientRepository;
        this.mapper = mapper;
    }


    @Override
    public List<ClientDTO> getClients() {
        List<ClientEntity> clients = clientRepository.findAll();
        return clients.stream()
                .map(mapper::convert)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO getClient(String document) {
        clientValidator.validateDocumentFormat(document);
        ClientEntity clientEntity = clientRepository.findByDocument(document);
        if (clientEntity == null) {
            throw new ClientNotFoundException("No existe cliente con el número de documento suministrado");
        }
        return mapper.convert(clientEntity);
    }

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        clientValidator.validateCliente(clientDTO);
        clientValidator.validateDocumentFormat(clientDTO.getDocument());

        if(clientRepository.existsByDocument(clientDTO.getDocument())){
            throw new DocumentExistsException("El cliente ya existe");
        }
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setName(clientDTO.getName());
        clientEntity.setDocument(clientDTO.getDocument());
        clientEntity.setEmail(clientDTO.getEmail());
        clientEntity.setPhone(clientDTO.getPhone());
        clientEntity.setDeliveryAddress(clientDTO.getDeliveryAddress());
//        ClientEntity clientEntity = ClientEntity.builder()
//                .name(clientDTO.getName())
//                .document(clientDTO.getDocument())
//                .email(clientDTO.getEmail())
//                .phone(clientDTO.getPhone())
//                .deliveryAddress(clientDTO.getDeliveryAddress())
//                .build();
        clientRepository.save(clientEntity);
        return mapper.convert(clientEntity);
    }

    @Override
    public ClientDTO updateClient(String document, ClientDTO clientDTO) {

        clientValidator.validateCliente(clientDTO);
        clientValidator.validateDocumentFormat(clientDTO.getDocument());
        ClientEntity clientEntity = clientRepository.findByDocument(document);

        if (clientEntity == null) {
            throw new ClientNotFoundException("Client with docuement:  " + clientDTO.getDocument() + "not found");
        }

        try {
            clientEntity.setName(clientDTO.getName());
            clientEntity.setDocument(clientDTO.getDocument());
            clientEntity.setEmail(clientDTO.getEmail());
            clientEntity.setPhone(clientDTO.getPhone());
            clientEntity.setDeliveryAddress(clientDTO.getDeliveryAddress());
            clientRepository.save(clientEntity);
            return mapper.convert(clientEntity);
        } catch (Exception e) {
            throw new InternalServerError("Error general del servidor al actualizar el cliente");
        }
    }

    @Override
    public void deleteClient(String document) {
        clientValidator.validateDocumentFormat(document);
        ClientEntity clientEntity = clientRepository.findByDocument(document);
        if (clientEntity == null) {
            throw new ClientNotFoundException("No se encontró ningún cliente con el documento proporcionado");
        }
        clientRepository.delete(clientEntity);
    }
}
