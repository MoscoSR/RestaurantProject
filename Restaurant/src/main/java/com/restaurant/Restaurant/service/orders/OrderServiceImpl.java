package com.restaurant.Restaurant.service.orders;

import com.restaurant.Restaurant.models.dto.OrderDTO;
import com.restaurant.Restaurant.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderServiceImpl implements IOrderService{

    // Usa el repository para buscar por uuid
    @Autowired
    IOrderRepository repository;

    @Override
    public OrderDTO createOrder(OrderDTO dto) {
        return null;
    }


    // Asignacion para Juan Carlos
    @Override
    public OrderDTO updateOrderDelivered(OrderDTO dto, LocalDateTime time) {
        /*
        Te van a pasar dos objetos:
        uno que es el uuid que se quiere actualizar
        y otro que es la hora de entrega del pedido (parametro time)
         */

        // Busca con el uuid del dto que te llega por parametro, que ya exista en la base de datos usando el OrderRepository.

        // luego de haberlo encontrado, actualiza UNICAMENTE "deliveredDate" con el parametro time
        // Y cambia el estado de la variable delivered de "false" a "true".


        /*
        finalmente debes retornar un objeto OrderDto con todos los valores que aparece en el API contract y los
        campos actualizados que te mencione arriba.
         */
        return null;
    }
}
