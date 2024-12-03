package com.project.accounts.services.client;

import com.project.accounts.constants.CardsConstants;
import com.project.accounts.dtos.CardsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(CardsConstants.CARDS_FEIGN_CLIENT)
public interface CardsFeignClient {

    @GetMapping(value = CardsConstants.CARDS_BASIC_URL + CardsConstants.FETCH_CARD_URL, consumes = CardsConstants.CARDS_DATA_FORMAT)
    public ResponseEntity<CardsDTO> fetchCardDetails(@RequestHeader("bank-correlation-id") String correlationId,
                                                        @RequestParam String mobileNumber);
}
