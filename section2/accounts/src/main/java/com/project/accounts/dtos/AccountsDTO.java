package com.project.accounts.dtos;

import com.project.accounts.constants.AccountsConstants;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDTO {

    @NotEmpty(message = AccountsConstants.ACCOUNT_NUMBER_NOT_EMPTY)
    @Pattern(regexp = AccountsConstants.ACCOUNT_NUMBER_PATTERN, message = AccountsConstants.ACCOUNT_NUMBER_LENGTH)
    private Long accountNumber;

    @NotEmpty(message = AccountsConstants.ACCOUNT_TYPE_NOT_EMPTY)
    private String accountType;

    @NotEmpty(message = AccountsConstants.ACCOUNT_BRANCH_ADDRESS_NOT_EMPTY)
    private String branchAddress;
}
