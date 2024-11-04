package com.project.loans.controllers;

import com.project.loans.constants.LoansConstants;
import com.project.loans.constants.SwaggerConstants;
import com.project.loans.dtos.ErrorResponseDTO;
import com.project.loans.dtos.LoansContactInfoDTO;
import com.project.loans.dtos.LoansDTO;
import com.project.loans.dtos.ResponseDTO;
import com.project.loans.services.ILoansService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = SwaggerConstants.LOANS_API_TAG_NAME,
        description = SwaggerConstants.LOANS_API_TAG_DESCRIPTION
)
@RestController
@RequestMapping(path = LoansConstants.LOAN_BASE_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class LoansController {

    @Autowired
    private ILoansService loansService;

    @Value(LoansConstants.ACCOUNT_VERSION_PROPERTY)
    private String buildVersion;

    @Autowired
    private Environment environment;

    @Autowired
    private LoansContactInfoDTO accountsContactInfoDTO;

    @Operation(
            summary = SwaggerConstants.CREATE_LOAN_SUMMARY,
            description = SwaggerConstants.CREATE_LOAN_DESCRIPTION
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
    @PostMapping(LoansConstants.CREATE_LOAN_URI)
    public ResponseEntity<ResponseDTO> createLoan(@RequestParam
                                                  @Pattern(regexp = LoansConstants.MOBILE_NUMBER_REGEX,
                                                  message = LoansConstants.MOBILE_NUMBER_LENGTH)
                                                  String mobileNumber) {
        loansService.createLoan(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(LoansConstants.STATUS_201, LoansConstants.MESSAGE_201));
    }

    @Operation(
            summary = SwaggerConstants.FETCH_LOAN_SUMMARY,
            description = SwaggerConstants.FETCH_LOAN_DESCRIPTION
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
    @GetMapping(LoansConstants.FETCH_LOAN_URI)
    public ResponseEntity<LoansDTO> getLoanDetails(@RequestParam
                                                   @Pattern(regexp = LoansConstants.MOBILE_NUMBER_REGEX,
                                                   message = LoansConstants.MOBILE_NUMBER_LENGTH)
                                                   String mobileNumber) {
        LoansDTO loansDTO = loansService.fetchLoan(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(loansDTO);
    }

    @Operation(
            summary = SwaggerConstants.UPDATE_LOAN_SUMMARY,
            description = SwaggerConstants.UPDATE_LOAN_DESCRIPTION
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
    @PutMapping(LoansConstants.UPDATE_LOAN_URI)
    public ResponseEntity<ResponseDTO> updateLoanDetails(@Valid @RequestBody LoansDTO loansDTO) {
        boolean isUpdated = loansService.updateLoan(loansDTO);
        if(isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200));
        }
        return ResponseEntity
                .status(HttpStatus.EXPECTATION_FAILED)
                .body(new ResponseDTO(LoansConstants.STATUS_417, LoansConstants.MESSAGE_417_UPDATE));
    }

    @Operation(
            summary = SwaggerConstants.DELETE_LOAN_SUMMARY,
            description = SwaggerConstants.DELETE_LOAN_DESCRIPTION
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
    @DeleteMapping(LoansConstants.DELETE_LOAN_URI)
    public ResponseEntity<ResponseDTO> deleteLoanDetails(@RequestParam
                                                         @Pattern(regexp = LoansConstants.MOBILE_NUMBER_REGEX,
                                                         message = LoansConstants.MOBILE_NUMBER_LENGTH)
                                                         String mobileNumber) {
        boolean isDeleted = loansService.deleteLoan(mobileNumber);
        if(isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200));
        }
        return ResponseEntity
                .status(HttpStatus.EXPECTATION_FAILED)
                .body(new ResponseDTO(LoansConstants.STATUS_417, LoansConstants.MESSAGE_417_DELETE));
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
    @GetMapping(LoansConstants.BUILD_INFO)
    public ResponseEntity<String> getBuildInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(buildVersion);
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
    @GetMapping(LoansConstants.JAVA_VERSION)
    public ResponseEntity<String> getJavaVersion() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(environment.getProperty(LoansConstants.JAVA_VERSION_PROPERTY));
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
    @GetMapping(LoansConstants.CONTACT_INFO)
    public ResponseEntity<LoansContactInfoDTO> getContactInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(accountsContactInfoDTO);
    }
}
