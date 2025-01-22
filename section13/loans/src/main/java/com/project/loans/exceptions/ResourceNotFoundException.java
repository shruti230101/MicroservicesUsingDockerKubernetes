package com.project.loans.exceptions;

import com.project.loans.constants.LoansConstants;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
        super(String.format(LoansConstants.RESOURCE_NOT_FOUND_EXCEPTION, resourceName, fieldName, fieldValue));
    }
}