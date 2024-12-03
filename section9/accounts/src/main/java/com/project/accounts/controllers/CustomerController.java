package com.project.accounts.controllers;

import com.project.accounts.constants.CustomerConstants;
import com.project.accounts.constants.SwaggerConstants;
import com.project.accounts.dtos.CustomerDetailsDTO;
import com.project.accounts.dtos.ErrorResponseDTO;
import com.project.accounts.services.ICustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = SwaggerConstants.CUSTOMER_CONTROLLER_TAG_NAME, description = SwaggerConstants.CUSTOMER_CONTROLLER_TAG_DESCRIPTION)
@RestController
@RequestMapping(path = CustomerConstants.BASE_PATH, produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private ICustomerService iCustomerService;

    @Operation(summary = SwaggerConstants.FETCH_CUSTOMER_DETAILS_SUMMARY,
            description = SwaggerConstants.FETCH_CUSTOMER_DETAILS_DESCRIPTION
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = SwaggerConstants.STATUS_200,
                    description = SwaggerConstants.STATUS_200_MESSAGE
            ),
            @ApiResponse(
                    responseCode = SwaggerConstants.STATUS_500,
                    description = SwaggerConstants.STATUS_500_MESSAGE,
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )
    })
    @GetMapping(CustomerConstants.FETCH_CUSTOMER_DETAILS)
    public ResponseEntity<CustomerDetailsDTO> fetchCustomerDetails(@RequestHeader("bank-correlation-id") String correlationId,
                                                                   @RequestParam
                                                                   @Pattern(regexp = CustomerConstants.CUSTOMER_MOBILE_NUMBER_PATTERN,
                                                                           message = CustomerConstants.CUSTOMER_MOBILE_NUMBER_LENGTH)
                                                                   String mobileNumber)
    {
        logger.debug("bank-correlation-id found: {}", correlationId);
        CustomerDetailsDTO customerDetailsDTO = iCustomerService.fetchCustomerDetails(mobileNumber, correlationId);
        return ResponseEntity.status(HttpStatus.OK).body(customerDetailsDTO);
    }
}
