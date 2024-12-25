package com.project.accounts.controllers;

import com.project.accounts.constants.AccountsConstants;
import com.project.accounts.constants.CustomerConstants;
import com.project.accounts.constants.SwaggerConstants;
import com.project.accounts.dtos.AccountsContactInfoDTO;
import com.project.accounts.dtos.CustomerDTO;
import com.project.accounts.dtos.ErrorResponseDTO;
import com.project.accounts.dtos.ResponseDTO;
import com.project.accounts.services.IAccountService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeoutException;

@Tag(name = SwaggerConstants.ACCOUNTS_MS_TAG_NAME,
        description = SwaggerConstants.ACCOUNTS_MS_TAG_DESCRIPTION
)
@RestController
@RequestMapping(path = AccountsConstants.BASE_PATH,
        produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class AccountsController {

    private static final Logger logger = LoggerFactory.getLogger(AccountsController.class);

    @Autowired
    private IAccountService accountService;

    @Value(AccountsConstants.ACCOUNT_VERSION_PROPERTY)
    private String buildVersion;

    @Autowired
    private Environment environment;

    @Autowired
    private AccountsContactInfoDTO accountsContactInfoDTO;

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

    @Operation(summary = SwaggerConstants.BUILD_INFO_SUMMARY,
            description = SwaggerConstants.BUILD_DESCRIPTION
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
    @Retry(name = "getBuildInfo", fallbackMethod = "getBuildInfoFallback")
    @GetMapping(AccountsConstants.BUILD_INFO)
    public ResponseEntity<String> getBuildInfo() throws TimeoutException {
//        logger.debug("getBuildInfo() method invoked.");
//        throw new NullPointerException();
//        throw new TimeoutException();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(buildVersion);
    }

    public ResponseEntity<String> getBuildInfoFallback(Throwable throwable) {
        logger.debug("getBuildInfoFallback() method invoked.");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("0.9");
    }

    @Operation(summary = SwaggerConstants.JAVA_VERSION_SUMMARY,
            description = SwaggerConstants.JAVA_VERSION_DESCRIPTION
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
    @RateLimiter(name = "getJavaVersion", fallbackMethod = "getJavaVersionFallback")
    @GetMapping(AccountsConstants.JAVA_VERSION)
    public ResponseEntity<String> getJavaVersion() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(environment.getProperty(AccountsConstants.JAVA_VERSION_PROPERTY));
    }

    public ResponseEntity<String> getJavaVersionFallback(Throwable throwable) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Java 17");
    }

    @Operation(summary = SwaggerConstants.CONTACT_INFO_SUMMARY,
            description = SwaggerConstants.CONTACT_INFO_DESCRIPTION
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
    @GetMapping(AccountsConstants.CONTACT_INFO)
    public ResponseEntity<AccountsContactInfoDTO> getContactInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(accountsContactInfoDTO);
    }
}