package com.project.cards.exceptions;

import com.project.cards.constants.CardsConstants;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue){
        super(String.format(CardsConstants.RESOURCE_NOT_FOUND_EXCEPTION_STRING_FORMAT, resourceName, fieldName, fieldValue));
    }
}