package com.project.accounts.dtos;

import com.project.accounts.constants.CustomerConstants;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDTO {

    @NotEmpty(message = CustomerConstants.CUSTOMER_NAME_NOT_EMPTY)
    @Size(min = CustomerConstants.CUSTOMER_NAME_MIN_SIZE,
            max = CustomerConstants.CUSTOMER_NAME_MAX_SIZE,
            message = CustomerConstants.CUSTOMER_NAME_LENGTH)
    private String name;

    @NotEmpty(message = CustomerConstants.CUSTOMER_EMAIL_NOT_EMPTY)
    @Email(message = CustomerConstants.CUSTOMER_EMAIL_VALID)
    private String email;

    @Pattern(regexp = CustomerConstants.CUSTOMER_MOBILE_NUMBER_PATTERN, message = CustomerConstants.CUSTOMER_MOBILE_NUMBER_LENGTH)
    private String mobileNumber;

    private AccountsDTO accountsDTO;
}
