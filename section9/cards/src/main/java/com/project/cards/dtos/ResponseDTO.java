package com.project.cards.dtos;

import com.project.cards.constants.SwaggerConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(
        name = SwaggerConstants.RESPONSE_SCHEMA_NAME,
        description = SwaggerConstants.RESPONSE_SCHEMA_DESCRIPTION
)
@Data
@AllArgsConstructor
public class ResponseDTO {

    @Schema(description = SwaggerConstants.RESPONSE_SCHEMA_STATUS_CODE_FIELD_DESCRIPTION)
    private String statusCode;

    @Schema(description = SwaggerConstants.RESPONSE_SCHEMA_STATUS_MESSAGE_FIELD_DESCRIPTION)
    private String statusMessage;
}