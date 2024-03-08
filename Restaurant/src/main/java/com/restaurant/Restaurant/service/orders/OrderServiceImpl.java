package com.restaurant.Restaurant.service.orders;

import com.restaurant.Restaurant.entity.OrderEntity;
import com.restaurant.Restaurant.mapper.OrderEntityToDtoMapper;
import com.restaurant.Restaurant.models.dto.OrderDTO;
import com.restaurant.Restaurant.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class OrderServiceImpl implements IOrderService{

    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private OrderEntityToDtoMapper mapper;

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUuid(orderDTO.getUuid());
        orderEntity.setCreationDateTime(orderDTO.getCreationDateTime());
        orderEntity.setClientDocument(orderDTO.getClientDocument());
        orderEntity.setProductUuid(orderDTO.getProductUuid());
        orderEntity.setQuantity(orderDTO.getQuantity());
        orderEntity.setExtraInformation(orderDTO.getExtraInformation());
        orderEntity.setSubTotal(orderDTO.getGrandTotal());
        orderEntity.setTax(orderDTO.getGrandTotal());
        orderEntity.setGrandTotal(orderDTO.getGrandTotal());

        orderRepository.save(orderEntity);

        return mapper.convert(orderEntity);
    }

    @Override
    public OrderDTO updateOrderDelivered(Long uuid, LocalDateTime timeStamp, OrderDTO orderDTO) {
        OrderEntity orderEntity = orderRepository.findById(uuid).orElse(null);
        orderEntity.setDelivered(true);
        orderEntity.setDeliveredDateTime(timeStamp);
        orderRepository.save(orderEntity);
        return mapper.convert(orderEntity);
    }
}
