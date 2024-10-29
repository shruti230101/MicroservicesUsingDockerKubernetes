package com.project.accounts.controllers;

import com.project.accounts.constants.AccountsConstants;
import com.project.accounts.constants.CustomerConstants;
import com.project.accounts.constants.SwaggerConstants;
import com.project.accounts.dtos.CustomerDTO;
import com.project.accounts.dtos.ErrorResponseDTO;
import com.project.accounts.dtos.ResponseDTO;
import com.project.accounts.services.IAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = SwaggerConstants.ACCOUNTS_MS_TAG_NAME,
        description = SwaggerConstants.ACCOUNTS_MS_TAG_DESCRIPTION
)
@RestController
@RequestMapping(path = AccountsConstants.BASE_PATH,
        produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class AccountsController {

    private IAccountService accountService;

    @Operation(summary = SwaggerConstants.CREATE_ACCOUNT_SUMMARY,
                description = SwaggerConstants.CREATE_ACCOUNT_DESCRIPTION
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = SwaggerConstants.STATUS_201,
                    description = SwaggerConstants.STATUS_201_MESSAGE
            ),
            @ApiResponse(
                    responseCode = SwaggerConstants.STATUS_500,
                    description = SwaggerConstants.STATUS_500_MESSAGE,
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )
    })
    @PostMapping(AccountsConstants.CREATE_ACCOUNT)
    public ResponseEntity<ResponseDTO> createAccount(@Valid @RequestBody CustomerDTO customerDTO) {
        accountService.createAccount(customerDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }

    @Operation(summary = SwaggerConstants.FETCH_ACCOUNT_SUMMARY,
            description = SwaggerConstants.FETCH_ACCOUNT_DESCRIPTION
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
    @GetMapping(AccountsConstants.FETCH_ACCOUNT)
    public ResponseEntity<CustomerDTO> fetchAccountDetails(@RequestParam
                                                               @Pattern(regexp = CustomerConstants.CUSTOMER_MOBILE_NUMBER_PATTERN,
                                                                       message = CustomerConstants.CUSTOMER_MOBILE_NUMBER_LENGTH)
                                                               String mobileNumber) {
        CustomerDTO customerDTO = accountService.fetchAccount(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerDTO);
    }

    @Operation(summary = SwaggerConstants.UPDATE_ACCOUNT_SUMMARY,
            description = SwaggerConstants.UPDATE_ACCOUNT_DESCRIPTION
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = SwaggerConstants.STATUS_200,
                    description = SwaggerConstants.STATUS_200_MESSAGE
            ),
            @ApiResponse(
                    responseCode = SwaggerConstants.STATUS_417,
                    description = SwaggerConstants.STATUS_417_MESSAGE
            ),
            @ApiResponse(
                    responseCode = SwaggerConstants.STATUS_500,
                    description = SwaggerConstants.STATUS_500_MESSAGE,
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )
    })
    @PutMapping(AccountsConstants.UPDATE_ACCOUNT)
    public ResponseEntity<ResponseDTO> updateAccountDetails(@Valid @RequestBody CustomerDTO customerDTO) {
        boolean isUpdated = accountService.updateAccount(customerDTO);
        if(isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        }
        return ResponseEntity
                .status(HttpStatus.EXPECTATION_FAILED)
                .body(new ResponseDTO(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_UPDATE));
    }

    @Operation(summary = SwaggerConstants.DELETE_ACCOUNT_SUMMARY,
            description = SwaggerConstants.DELETE_ACCOUNT_DESCRIPTION
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = SwaggerConstants.STATUS_200,
                    description = SwaggerConstants.STATUS_200_MESSAGE
            ),
            @ApiResponse(
                    responseCode = SwaggerConstants.STATUS_417,
                    description = SwaggerConstants.STATUS_417_MESSAGE
            ),
            @ApiResponse(
                    responseCode = SwaggerConstants.STATUS_500,
                    description = SwaggerConstants.STATUS_500_MESSAGE
            )
    })
    @DeleteMapping(AccountsConstants.DELETE_ACCOUNT)
    public ResponseEntity<ResponseDTO> deleteAccountDetails(@RequestParam
                                                            @Pattern(regexp = CustomerConstants.CUSTOMER_MOBILE_NUMBER_PATTERN,
                                                                    message = CustomerConstants.CUSTOMER_MOBILE_NUMBER_LENGTH)
                                                                String mobileNumber) {
        boolean isDeleted = accountService.deleteAccount(mobileNumber);
        if(isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        }
        return ResponseEntity
                .status(HttpStatus.EXPECTATION_FAILED)
                .body(new ResponseDTO(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_DELETE));
    }
}