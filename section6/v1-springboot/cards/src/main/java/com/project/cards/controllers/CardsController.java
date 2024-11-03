package com.project.cards.controllers;

import com.project.cards.constants.CardsConstants;
import com.project.cards.constants.SwaggerConstants;
import com.project.cards.dtos.CardsDTO;
import com.project.cards.dtos.ErrorResponseDTO;
import com.project.cards.dtos.ResponseDTO;
import com.project.cards.services.ICardsService;
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

@Tag(
        name = SwaggerConstants.CARDS_MS_TAG_NAME,
        description = SwaggerConstants.CARDS_MS_TAG_DESCRIPTION
)
@RestController
@RequestMapping(path = CardsConstants.CARDS_BASIC_URL,
        produces = {MediaType.APPLICATION_JSON_VALUE}
)
@AllArgsConstructor
@Validated
public class CardsController {

    private ICardsService iCardsService;

    @Operation(
            summary = SwaggerConstants.CREATE_CARD_API_SUMMARY,
            description = SwaggerConstants.CREATE_CARD_API_DESCRIPTION
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
    @PostMapping(CardsConstants.CREATE_CARD_URL)
    public ResponseEntity<ResponseDTO> createCard(@Valid @RequestParam
                                                @Pattern(regexp = CardsConstants.CARDS_MOBILE_NUMBER_REGEX,
                                                        message = CardsConstants.CARDS_MOBILE_NUMBER_LENGTH)
                                                      String mobileNumber) {
        iCardsService.createCard(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(CardsConstants.STATUS_201, CardsConstants.MESSAGE_201));
    }

    @Operation(
            summary = SwaggerConstants.FETCH_CARD_API_SUMMARY,
            description = SwaggerConstants.FETCH_CARD_API_DESCRIPTION
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
    @GetMapping(CardsConstants.FETCH_CARD_URL)
    public ResponseEntity<CardsDTO> fetchCardDetails(@Valid @RequestParam
                                                     @Pattern(regexp = CardsConstants.CARDS_MOBILE_NUMBER_REGEX,
                                                     message = CardsConstants.CARDS_MOBILE_NUMBER_LENGTH)
                                                     String mobileNumber) {
        CardsDTO cardsDTO = iCardsService.fetchCard(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(cardsDTO);
    }

    @Operation(
            summary = SwaggerConstants.UPDATE_CARD_API_SUMMARY,
            description = SwaggerConstants.UPDATE_CARD_API_DESCRIPTION
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
    @PutMapping(CardsConstants.UPDATE_CARD_URL)
    public ResponseEntity<ResponseDTO> updateCardDetails(@Valid @RequestBody CardsDTO cardsDTO) {
        boolean isUpdated = iCardsService.updateCard(cardsDTO);
        if(isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200));
        }
        return ResponseEntity
                .status(HttpStatus.EXPECTATION_FAILED)
                .body(new ResponseDTO(CardsConstants.STATUS_417, CardsConstants.MESSAGE_417));
    }

    @Operation(
            summary = SwaggerConstants.DELETE_CARD_API_SUMMARY,
            description = SwaggerConstants.DELETE_CARD_API_DESCRIPTION
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
    @DeleteMapping(CardsConstants.DELETE_CARD_URL)
    public ResponseEntity<ResponseDTO> deleteCard(@Valid @RequestParam
                                                      @Pattern(regexp = CardsConstants.CARDS_MOBILE_NUMBER_REGEX,
                                                              message = CardsConstants.CARDS_MOBILE_NUMBER_LENGTH)
                                                      String mobileNumber) {
        boolean isDeleted = iCardsService.deleteCard(mobileNumber);
        if(isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200));
        }
        return ResponseEntity
                .status(HttpStatus.EXPECTATION_FAILED)
                .body(new ResponseDTO(CardsConstants.STATUS_417, CardsConstants.MESSAGE_417));
    }
}
