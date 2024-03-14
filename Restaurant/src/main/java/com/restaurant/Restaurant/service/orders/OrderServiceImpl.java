package com.restaurant.Restaurant.service.orders;

import com.restaurant.Restaurant.converter.DoubleTwoDecimals;
import com.restaurant.Restaurant.entity.OrderEntity;
import com.restaurant.Restaurant.entity.ClientEntity;
import com.restaurant.Restaurant.entity.ProductEntity;
import com.restaurant.Restaurant.mapper.OrderEntityToDtoMapper;
import com.restaurant.Restaurant.models.dto.OrderDTO;
import com.restaurant.Restaurant.repository.ClientRepository;
import com.restaurant.Restaurant.repository.IOrderRepository;
import com.restaurant.Restaurant.repository.IProductRepositoryJPA;
import com.restaurant.Restaurant.validator.ClientValidator;
import com.restaurant.Restaurant.validator.OrderValidator;
import com.restaurant.Restaurant.validator.ProductValidator;
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

    private final ClientValidator clientValidator;

    private final DoubleTwoDecimals doubleTwoDecimals;

    private final ProductValidator productValidator;

    public OrderServiceImpl(IOrderRepository orderRepository, OrderEntityToDtoMapper mapper, IProductRepositoryJPA productRepository, OrderValidator orderValidator, ClientRepository clientRepository, ClientValidator clientValidator, DoubleTwoDecimals doubleTwoDecimals, ProductValidator productValidator) {
        this.orderRepository = orderRepository;
        this.mapper = mapper;
        this.productRepository = productRepository;
        this.orderValidator = orderValidator;
        this.clientRepository = clientRepository;
        this.clientValidator = clientValidator;
        this.doubleTwoDecimals = doubleTwoDecimals;
        this.productValidator = productValidator;

    }


    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {

        ProductEntity product = productRepository.findByUuid(orderDTO.getProductUuid());
        ClientEntity client = clientRepository.findByDocument(orderDTO.getClientDocument());

        orderValidator.verifyFields(orderDTO);
        orderValidator.uuidValidFormat(orderDTO.getProductUuid());
        orderValidator.verifyProductExists(product, orderDTO);
        orderValidator.verifyClientExists(client, orderDTO);
        clientValidator.validateDocumentFormat(orderDTO.getClientDocument());
        productValidator.validateUuid(orderDTO.getProductUuid());

        double subTotal =  product.getPrice() * orderDTO.getQuantity();
        double tax = subTotal * 0.19;
        double grandTotal = subTotal + tax;

        OrderEntity orderEntity = new OrderEntity();
            orderEntity.setUuid(UUID.randomUUID().toString());
            orderEntity.setCreationDateTime(LocalDateTime.now());
            orderEntity.setClientDocument(orderDTO.getClientDocument());
            orderEntity.setProductUuid(orderDTO.getProductUuid());
            orderEntity.setQuantity(orderDTO.getQuantity());
            orderEntity.setExtraInformation(orderDTO.getExtraInformation());
            orderEntity.setSubTotal(doubleTwoDecimals.convert(subTotal));
            orderEntity.setTax(doubleTwoDecimals.convert(tax));
            orderEntity.setGrandTotal(doubleTwoDecimals.convert(grandTotal));
            return mapper.convert(orderRepository.save(orderEntity));
    }


    @Override
    public OrderDTO updateOrderDeliveredByUuid(String uuid, LocalDateTime timeStamp, OrderDTO orderDTO) {
        OrderEntity orderEntity = orderRepository.findByUuid(uuid).orElse(null);
        orderValidator.validateOrder(orderEntity, orderDTO);
        orderValidator.uuidValidFormat(uuid);
        orderEntity.setDelivered(true);
        orderEntity.setDeliveredDate(timeStamp);
        orderRepository.save(orderEntity);
        return mapper.convert(orderEntity);
    }
}
