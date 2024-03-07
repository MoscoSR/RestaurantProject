package com.restaurant.Restaurant.validator;

import com.restaurant.Restaurant.exception.impl.InvalidOrIncompleteDataException;
import com.restaurant.Restaurant.models.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductValidator {

    public void validateProductDto(ProductDTO productDTO){

        if (productDTO.getFantasyName()==null || productDTO.getFantasyName().isEmpty()){
            throw new InvalidOrIncompleteDataException("Fantasy name is empty");
        }
        if ( productDTO.getCategory()==null ){
            throw new InvalidOrIncompleteDataException("Category is empty or Invalid");
        }
        if (productDTO.getDescription()==null || productDTO.getDescription().isEmpty()){
            throw new InvalidOrIncompleteDataException("Description is empty");
        }
        if ( productDTO.getPrice()==null || productDTO.getPrice()<=0D){
            throw new InvalidOrIncompleteDataException("Price is empty or invalid");
        }
        if (productDTO.getAvailable()==null ){
            throw new InvalidOrIncompleteDataException("Available is empty or invalid");
        }
    }
    public void validateUuid(String uuid){
        if (uuid==null || uuid.isEmpty()){
            throw new InvalidOrIncompleteDataException("Uuid not is valid");
        }
    }
}
