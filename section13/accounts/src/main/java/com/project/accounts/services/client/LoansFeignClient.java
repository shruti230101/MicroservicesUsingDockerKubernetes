package com.project.accounts.services.client;

import com.project.accounts.constants.LoansConstants;
import com.project.accounts.dtos.LoansDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = LoansConstants.LOANS_FEIGN_CLIENT, fallback = LoansFallback.class)
public interface LoansFeignClient {

    @GetMapping(value = LoansConstants.LOAN_BASE_PATH + LoansConstants.FETCH_LOAN_URI, consumes = LoansConstants.LOANS_DATA_FORMAT)
    public ResponseEntity<LoansDTO> fetchLoanDetails(@RequestHeader("bank-correlation-id") String correlationId,
                                                     @RequestParam String mobileNumber);
}
