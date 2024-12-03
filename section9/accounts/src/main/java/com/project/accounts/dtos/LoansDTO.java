package com.project.accounts.dtos;

import com.project.accounts.constants.LoansConstants;
import com.project.accounts.constants.SwaggerConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Schema(name = SwaggerConstants.LOAN_SCHEMA_NAME,
        description = SwaggerConstants.LOAN_SCHEMA_DESCRIPTION
)
@Data
public class LoansDTO {

    @NotEmpty(message = LoansConstants.MOBILE_NUMBER_NOT_EMPTY)
    @Pattern(regexp = LoansConstants.MOBILE_NUMBER_REGEX,
            message = LoansConstants.MOBILE_NUMBER_LENGTH)
    @Schema(description = SwaggerConstants.LOAN_MOBILE_NUMBER_DESCRIPTION,
            example = SwaggerConstants.LOAN_MOBILE_NUMBER_EXAMPLE)
    private String mobileNumber;

    @Schema(description = SwaggerConstants.LOAN_NUMBER_DESCRIPTION,
            example = SwaggerConstants.LOAN_NUMBER_EXAMPLE)
    @NotEmpty(message = LoansConstants.LOAN_NUMBER_NOT_EMPTY)
    private String loanNumber;

    @Schema(description = SwaggerConstants.LOAN_TYPE_DESCRIPTION,
            example = SwaggerConstants.LOAN_TYPE_EXAMPLE)
    @NotEmpty(message = LoansConstants.LOAN_TYPE_NOT_EMPTY)
    private String loanType;

    @Schema(description = SwaggerConstants.TOTAL_LOAN_AMOUNT_DESCRIPTION,
            example = SwaggerConstants.TOTAL_LOAN_AMOUNT_EXAMPLE)
    @Positive(message = LoansConstants.TOTAL_LOAN_CONDITION)
    private int totalLoan;

    @Schema(description = SwaggerConstants.LOAN_AMOUNT_PAID_DESCRIPTION,
            example = SwaggerConstants.LOAN_AMOUNT_PAID_EXAMPLE)
    @PositiveOrZero(message = LoansConstants.LOAN_AMOUNT_PAID_CONDITION)
    private int amountPaid;

    @Schema(description = SwaggerConstants.OUTSTANDING_AMOUNT_DESCRIPTION,
            example = SwaggerConstants.OUTSTANDING_AMOUNT_EXAMPLE)
    @PositiveOrZero(message = LoansConstants.TOTAL_OUTSTANDING_AMOUNT_CONDITION)
    private int outstandingAmount;
}
