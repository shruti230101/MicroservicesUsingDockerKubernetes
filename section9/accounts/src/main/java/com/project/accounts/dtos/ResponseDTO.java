package com.project.accounts.dtos;

import com.project.accounts.constants.SwaggerConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Schema(
        name = SwaggerConstants.RESPONSE_SCHEMA_NAME,
        description = SwaggerConstants.RESPONSE_SCHEMA_DESCRIPTION
)
@AllArgsConstructor
public class ResponseDTO {

    @Schema(description = SwaggerConstants.RESPONSE_STATUS_CODE_DESCRIPTION)
    private String statusCode;

    @Schema(description = SwaggerConstants.RESPONSE_STATUS_MESSAGE_DESCRIPTION)
    private String statusMessage;
}
