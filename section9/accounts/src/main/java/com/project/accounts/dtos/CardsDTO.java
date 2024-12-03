package com.project.accounts.dtos;

import com.project.accounts.constants.CardsConstants;
import com.project.accounts.constants.SwaggerConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Schema(name = SwaggerConstants.CARDS_SCHEMA_NAME,
        description = SwaggerConstants.CARDS_SCHEMA_DESCRIPTION
)
@Data
public class CardsDTO {

    @NotEmpty(message = CardsConstants.MOBILE_NUMBER_NOT_EMPTY)
    @Pattern(regexp = CardsConstants.MOBILE_NUMBER_REGEX,
            message = CardsConstants.MOBILE_NUMBER_LENGTH)
    @Schema(
            description = SwaggerConstants.CARDS_SCHEMA_MOBILE_FIELD_DESCRIPTION,
            example = SwaggerConstants.CARDS_SCHEMA_MOBILE_FIELD_EXAMPLE
    )
    private String mobileNumber;

    @NotEmpty(message = CardsConstants.CARD_NUMBER_NOT_EMPTY)
    @Pattern(regexp = CardsConstants.CARD_NUMBER_REGEX,
            message = CardsConstants.CARD_NUMBER_LENGTH)
    @Schema(
            description = SwaggerConstants.CARDS_SCHEMA_CARD_NUMBER_FIELD_DESCRIPTION,
            example = SwaggerConstants.CARDS_SCHEMA_CARD_NUMBER_FIELD_EXAMPLE
    )
    private String cardNumber;

    @NotEmpty(message = CardsConstants.CARD_TYPE_NOT_EMPTY)
    @Schema(
            description = SwaggerConstants.CARDS_SCHEMA_CARD_TYPE_FIELD_DESCRIPTION,
            example = SwaggerConstants.CARDS_SCHEMA_CARD_TYPE_FIELD_EXAMPLE
    )
    private String cardType;

    @Positive(message = CardsConstants.CARD_LIMIT_VALIDATION)
    @Schema(
            description = SwaggerConstants.CARDS_SCHEMA_TOTAL_LIMIT_FIELD_DESCRIPTION,
            example = SwaggerConstants.CARDS_SCHEMA_TOTAL_LIMIT_FIELD_EXAMPLE
    )
    private int totalLimit;

    @PositiveOrZero(message = CardsConstants.CARD_AMOUNT_USED_VALIDATION)
    @Schema(
            description = SwaggerConstants.CARDS_SCHEMA_AMOUNT_USED_FIELD_DESCRIPTION,
            example = SwaggerConstants.CARDS_SCHEMA_AMOUNT_USED_FIELD_EXAMPLE
    )
    private int amountUsed;

    @PositiveOrZero(message = CardsConstants.CARD_AMOUNT_AVAILABLE_VALIDATION)
    @Schema(
            description = SwaggerConstants.CARDS_SCHEMA_AVAILABLE_AMOUNT_FIELD_DESCRIPTION,
            example = SwaggerConstants.CARDS_SCHEMA_AVAILABLE_AMOUNT_FIELD_EXAMPLE
    )
    private int availableAmount;
}