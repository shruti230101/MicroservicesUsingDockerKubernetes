package com.project.loans.dtos;

import com.project.loans.constants.SwaggerConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(name = SwaggerConstants.ERROR_RESPONSE_SCHEMA_NAME,
        description = SwaggerConstants.ERROR_RESPONSE_SCHEMA_DESCRIPTION
)
@Data
@AllArgsConstructor
public class ErrorResponseDTO {

    @Schema(description = SwaggerConstants.ERROR_RESPONSE_API_PATH_DESCRIPTION)
    private String apiPath;

    @Schema(description = SwaggerConstants.ERROR_RESPONSE_STATUS_CODE_DESCRIPTION)
    private HttpStatus errorCode;

    @Schema(description = SwaggerConstants.ERROR_RESPONSE_STATUS_MESSAGE_DESCRIPTION)
    private String errorMessage;

    @Schema(description = SwaggerConstants.ERROR_RESPONSE_ERROR_TIME_DESCRIPTION)
    private LocalDateTime errorTime;
}
