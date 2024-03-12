package com.restaurant.Restaurant.service.order;

import com.restaurant.Restaurant.entity.OrderEntity;
import com.restaurant.Restaurant.mapper.OrderEntityToDtoMapper;
import com.restaurant.Restaurant.models.dto.OrderDTO;
import com.restaurant.Restaurant.repository.IOrderRepository;
import com.restaurant.Restaurant.service.orders.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplTest {

    private OrderDTO orderDTO;
    private OrderEntity orderEntity;

    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private IOrderRepository orderRepository;

    @Mock
    private OrderEntityToDtoMapper mapper;

    @BeforeEach
    public void setUp() {
        orderDTO = orderDTO.builder()
                .uuid("123")
                .creationDateTime(LocalDateTime.parse("2021-08-01T00:00:00"))
                .clientDocument("123456789")
                .productUuid("123")
                .quantity(1)
                .extraInformation("extra")
                .subTotal(10.0)
                .tax(1.0)
                .grandTotal(11.0)
                .delivered(false)
                .deliveredDateTime(LocalDateTime.parse("2021-08-01T00:00:00"))
                .build();
    }

    @Test
    void updateOrderDelivered() {
        Mockito.when(orderRepository.findById(orderEntity.getId())).thenReturn(Optional.empty());
        Mockito.when(mapper.convert(orderEntity)).thenReturn(orderDTO);
        Mockito.when(orderRepository.save(orderEntity)).thenReturn(orderEntity);

        var response = orderService.updateOrderDelivered(orderEntity.getId(), orderEntity.getDeliveredDateTime(), orderDTO);

        Assertions.assertEquals(orderDTO, response);
    }
}
