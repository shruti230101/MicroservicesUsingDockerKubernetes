package com.project.accounts.dtos;

import com.project.accounts.constants.CustomerConstants;
import com.project.accounts.constants.SwaggerConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = SwaggerConstants.CUSTOMER_SCHEMA_NAME,
        description = SwaggerConstants.CUSTOMER_SCHEMA_DESCRIPTION
)
public class CustomerDTO {

    @Schema(description = SwaggerConstants.CUSTOMER_FIELD_NAME_DESCRIPTION,
            example = SwaggerConstants.CUSTOMER_FIELD_NAME_EXAMPLE)
    @NotEmpty(message = CustomerConstants.CUSTOMER_NAME_NOT_EMPTY)
    @Size(min = CustomerConstants.CUSTOMER_NAME_MIN_SIZE,
            max = CustomerConstants.CUSTOMER_NAME_MAX_SIZE,
            message = CustomerConstants.CUSTOMER_NAME_LENGTH)
    private String name;

    @Schema(description = SwaggerConstants.CUSTOMER_FIELD_EMAIL_DESCRIPTION,
            example = SwaggerConstants.CUSTOMER_FIELD_EMAIL_EXAMPLE)
    @NotEmpty(message = CustomerConstants.CUSTOMER_EMAIL_NOT_EMPTY)
    @Email(message = CustomerConstants.CUSTOMER_EMAIL_VALID)
    private String email;

    @Schema(description = SwaggerConstants.CUSTOMER_FIELD_MOBILE_NUMBER_DESCRIPTION,
            example = SwaggerConstants.CUSTOMER_FIELD_MOBILE_NUMBER_EXAMPLE)
    @Pattern(regexp = CustomerConstants.CUSTOMER_MOBILE_NUMBER_PATTERN,
            message = CustomerConstants.CUSTOMER_MOBILE_NUMBER_LENGTH)
    private String mobileNumber;

    @Schema(description = SwaggerConstants.CUSTOMER_FIELD_ACCOUNTS_DESCRIPTION)
    private AccountsDTO accountsDTO;
}
