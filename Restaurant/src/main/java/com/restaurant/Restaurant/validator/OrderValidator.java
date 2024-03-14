package com.restaurant.Restaurant.validator;

import com.restaurant.Restaurant.entity.ClientEntity;
import com.restaurant.Restaurant.entity.OrderEntity;
import com.restaurant.Restaurant.entity.ProductEntity;
import com.restaurant.Restaurant.exception.impl.ClientNotFoundException;
import com.restaurant.Restaurant.exception.impl.InvalidOrIncompleteDataException;
import com.restaurant.Restaurant.exception.impl.OrderNotFoundException;
import com.restaurant.Restaurant.exception.impl.ProductNotFoundException;
import com.restaurant.Restaurant.models.dto.OrderDTO;
import com.restaurant.Restaurant.repository.IOrderRepository;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class OrderValidator {
    public void verifyFields(OrderDTO orderDTO) {
        if(orderDTO.getClientDocument() == null || orderDTO.getClientDocument().isEmpty() ||
                orderDTO.getProductUuid() == null || orderDTO.getProductUuid().isEmpty()
        ){
            throw new InvalidOrIncompleteDataException("Missing fields to make the order");
        }
        else if (orderDTO.getQuantity() == null || orderDTO.getQuantity() <= 0 || orderDTO.getQuantity() > 100){
            throw new InvalidOrIncompleteDataException("Invalid quantity in the order");
        }
        else if ((orderDTO.getExtraInformation().length()) > 511){
            throw new InvalidOrIncompleteDataException("The extra information is too long");
        }
    }

    public void validateOrder(OrderEntity orderEntity) {
        if(orderEntity == null){
            throw new OrderNotFoundException("The order with uuid does not exist");
        }
    }

    public void verifyProductExists(ProductEntity productEntity) {
        if(productEntity == null){
            throw new ProductNotFoundException("The product with uuid does not exist");
        }
    }

    public void verifyClientExists(ClientEntity clientEntity, OrderDTO orderDTO) {
        if(clientEntity == null){
            throw new ClientNotFoundException("The client with document " + orderDTO.getClientDocument() + " does not exist");
        }
    }

    public void uuidValidFormat (String uuid){
        Pattern pattern = Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");
        Matcher uuidValidFormat = pattern.matcher(uuid);

        if (!uuidValidFormat.matches()) {
            throw new InvalidOrIncompleteDataException("Uuid format not valid");
        }
    }

}