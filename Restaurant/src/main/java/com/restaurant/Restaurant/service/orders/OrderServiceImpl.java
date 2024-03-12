package com.restaurant.Restaurant.service.orders;

import com.restaurant.Restaurant.entity.ClientEntity;
import com.restaurant.Restaurant.entity.OrderEntity;
import com.restaurant.Restaurant.entity.ProductEntity;
import com.restaurant.Restaurant.exception.impl.ClientNotFoundException;
import com.restaurant.Restaurant.exception.impl.InvalidOrIncompleteDataException;
import com.restaurant.Restaurant.exception.impl.ProductNotFoundException;
import com.restaurant.Restaurant.mapper.OrderEntityToDtoMapper;
import com.restaurant.Restaurant.models.dto.OrderDTO;
import com.restaurant.Restaurant.repository.ClientRepository;
import com.restaurant.Restaurant.repository.IOrderRepository;
import com.restaurant.Restaurant.repository.IProductRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class OrderServiceImpl implements IOrderService{

    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private OrderEntityToDtoMapper mapper;

    @Autowired
    IProductRepositoryJPA productRepository;

    @Autowired
    ClientRepository clientRepository;

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {

        ProductEntity product = productRepository.findByUuid(orderDTO.getProductUuid());
        ClientEntity client = clientRepository.findByDocument(orderDTO.getClientDocument());

        if(orderDTO.getClientDocument() == null ||
                orderDTO.getProductUuid() == null ||
                orderDTO.getQuantity() == null
        ){
            throw new InvalidOrIncompleteDataException("Hacen falta campos por completar para hacer el pedido");
        }
        else if(product == null){
            throw new ProductNotFoundException("El producto con Uuid " + orderDTO.getProductUuid() + " no existe");
        }
        else if ( client == null){
            throw new ClientNotFoundException("El cliente con documento " + orderDTO.getClientDocument() + " no existe");
        }

        double subTotal =  product.getPrice() * orderDTO.getQuantity();
        double tax = subTotal * 0.16;
        double grandTotal = subTotal + tax;

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUuid(UUID.randomUUID().toString());
        orderEntity.setCreationDateTime(LocalDateTime.now());
        orderEntity.setClientDocument(orderDTO.getClientDocument());
        orderEntity.setProductUuid(orderDTO.getProductUuid());
        orderEntity.setQuantity(orderDTO.getQuantity());
        orderEntity.setExtraInformation(orderDTO.getExtraInformation());
        orderEntity.setSubTotal(subTotal);
        orderEntity.setTax(tax);
        orderEntity.setGrandTotal(grandTotal);

        return mapper.convert(orderRepository.save(orderEntity));
    }

    @Override
    public OrderDTO updateOrderDelivered(String uuid, LocalDateTime timeStamp, OrderDTO orderDTO) {

        Pattern pattern = Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");
        Matcher uuidValidFormat = pattern.matcher(uuid);

        OrderEntity orderEntity = orderRepository.findByUuid(uuid);
        if (!uuidValidFormat.matches()) {
            throw new InvalidOrIncompleteDataException("Formato de Uuid no valido");
        }else if( orderEntity == null){
            throw new ProductNotFoundException("El producto no existe");
        }

        orderEntity.setDelivered(true);
        orderEntity.setDeliveredDate(timeStamp);
        orderRepository.save(orderEntity);
        return mapper.convert(orderEntity);
    }

}
