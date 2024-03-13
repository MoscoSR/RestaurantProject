package com.restaurant.Restaurant.service.orders;

import com.restaurant.Restaurant.entity.OrderEntity;
import com.restaurant.Restaurant.entity.ClientEntity;
import com.restaurant.Restaurant.entity.ProductEntity;
import com.restaurant.Restaurant.mapper.OrderEntityToDtoMapper;
import com.restaurant.Restaurant.models.dto.OrderDTO;
import com.restaurant.Restaurant.repository.ClientRepository;
import com.restaurant.Restaurant.repository.IOrderRepository;
import com.restaurant.Restaurant.repository.IProductRepositoryJPA;
import com.restaurant.Restaurant.validator.OrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class OrderServiceImpl implements IOrderService{


    private final IOrderRepository orderRepository;


    private final OrderEntityToDtoMapper mapper;


    private final IProductRepositoryJPA productRepository;

    private final OrderValidator orderValidator;


    private final ClientRepository clientRepository;

    @Autowired
    public OrderServiceImpl(IOrderRepository orderRepository, OrderEntityToDtoMapper mapper, IProductRepositoryJPA productRepository, OrderValidator orderValidator, ClientRepository clientRepository) {
        this.orderRepository = orderRepository;
        this.mapper = mapper;
        this.productRepository = productRepository;
        this.orderValidator = orderValidator;
        this.clientRepository = clientRepository;
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {

        ProductEntity product = productRepository.findByUuid(orderDTO.getProductUuid());
        ClientEntity client = clientRepository.findByDocument(orderDTO.getClientDocument());

        orderValidator.validateOrderData(orderDTO);
        orderValidator.validateProduct(product, orderDTO);
        orderValidator.validateClient(client, orderDTO);

        double subTotal =  product.getPrice() * orderDTO.getQuantity();
        double tax = subTotal * 0.19D;
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

        orderRepository.save(orderEntity);

        return mapper.convert(orderEntity);
    }

    @Override
    public OrderDTO updateOrderDeliveredByUuid(String uuid, LocalDateTime timeStamp, OrderDTO orderDTO) {
        OrderEntity orderEntity = orderRepository.findByUuid(uuid).orElse(null);
        orderValidator.validateOrder(orderEntity, orderDTO);
        orderEntity.setDelivered(true);
        orderEntity.setDeliveredDateTime(timeStamp);
        orderRepository.save(orderEntity);
        return mapper.convert(orderEntity);
    }
}
