package com.project.accounts.dtos;

import com.project.accounts.constants.SwaggerConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Schema(name = SwaggerConstants.ERROR_RESPONSE_SCHEMA_NAME,
        description = SwaggerConstants.ERROR_RESPONSE_SCHEMA_DESCRIPTION)
@AllArgsConstructor
public class ErrorResponseDTO {

    @Schema(description = SwaggerConstants.ERROR_RESPONSE_SCHEMA_API_PATH_DESCRIPTION)
    private String apiPath;

    @Schema(description = SwaggerConstants.ERROR_RESPONSE_SCHEMA_ERROR_CODE_DESCRIPTION)
    private HttpStatus errorCode;

    @Schema(description = SwaggerConstants.ERROR_RESPONSE_SCHEMA_ERROR_MESSAGE_DESCRIPTION)
    private String errorMessage;

    @Schema(description = SwaggerConstants.ERROR_RESPONSE_SCHEMA_ERROR_TIME_DESCRIPTION)
    private LocalDateTime errorTime;
}
