package com.project.accounts.dtos;

import com.project.accounts.constants.AccountsConstants;
import com.project.accounts.constants.SwaggerConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = SwaggerConstants.ACCOUNTS_SCHEMA_NAME,
        description = SwaggerConstants.ACCOUNTS_SCHEMA_DESCRIPTION
)
public class AccountsDTO {

    @Schema(description = SwaggerConstants.ACCOUNTS_FIELD_ACCOUNT_NUMBER_DESCRIPTION,
            example = SwaggerConstants.ACCOUNTS_FIELD_ACCOUNT_NUMBER_EXAMPLE)
    @NotEmpty(message = AccountsConstants.ACCOUNT_NUMBER_NOT_EMPTY)
    @Pattern(regexp = AccountsConstants.ACCOUNT_NUMBER_PATTERN,
            message = AccountsConstants.ACCOUNT_NUMBER_LENGTH)
    private Long accountNumber;

    @Schema(description = SwaggerConstants.ACCOUNTS_FIELD_ACCOUNT_TYPE_DESCRIPTION,
            example = SwaggerConstants.ACCOUNTS_FIELD_ACCOUNT_TYPE_EXAMPLE)
    @NotEmpty(message = AccountsConstants.ACCOUNT_TYPE_NOT_EMPTY)
    private String accountType;

    @Schema(description = SwaggerConstants.ACCOUNTS_FIELD_BRANCH_ADDRESS_DESCRIPTION,
            example = SwaggerConstants.ACCOUNTS_FIELD_BRANCH_ADDRESS_EXAMPLE)
    @NotEmpty(message = AccountsConstants.ACCOUNT_BRANCH_ADDRESS_NOT_EMPTY)
    private String branchAddress;
}
