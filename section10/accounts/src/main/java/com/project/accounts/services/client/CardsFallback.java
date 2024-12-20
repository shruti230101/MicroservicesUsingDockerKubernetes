package com.project.accounts.services.client;

import com.project.accounts.dtos.CardsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CardsFallback implements CardsFeignClient{
    @Override
    public ResponseEntity<CardsDTO> fetchCardDetails(String correlationId, String mobileNumber) {
        return null;
    }
}
