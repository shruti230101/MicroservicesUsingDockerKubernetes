package com.project.loans.services;

import com.project.loans.dtos.LoansDTO;

public interface ILoansService {
    void createLoan(String mobileNumber);
    LoansDTO fetchLoan(String mobileNumber);
    boolean updateLoan(LoansDTO loansDto);
    boolean deleteLoan(String mobileNumber);
}
