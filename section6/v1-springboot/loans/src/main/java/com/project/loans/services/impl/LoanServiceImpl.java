package com.project.loans.services.impl;

import com.project.loans.constants.LoansConstants;
import com.project.loans.dtos.LoansDTO;
import com.project.loans.entities.Loans;
import com.project.loans.exceptions.LoanAlreadyExistsException;
import com.project.loans.exceptions.ResourceNotFoundException;
import com.project.loans.mapper.LoansMapper;
import com.project.loans.repositories.LoansRepository;
import com.project.loans.services.ILoansService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements ILoansService {

    private LoansRepository loansRepository;

    @Override
    public void createLoan(String mobileNumber) {
        Optional<Loans> loans = loansRepository.findByMobileNumber(mobileNumber);
        if(loans.isPresent()) {
            throw new LoanAlreadyExistsException(LoansConstants.LOAN_ALREADY_EXISTS_EXCEPTION + mobileNumber);
        }
        loansRepository.save(createNewLoan(mobileNumber));
    }

    private Loans createNewLoan(String mobileNumber) {
        Loans newLoan = new Loans();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setMobileNumber(mobileNumber);
        newLoan.setLoanType(LoansConstants.HOME_LOAN);
        newLoan.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT);
        return newLoan;
    }

    @Override
    public LoansDTO fetchLoan(String mobileNumber) {
        Loans loans = loansRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException(
                        LoansConstants.LOAN_RESOURCE, LoansConstants.LOAN_RESOURCE_MOBILE_FIELD, mobileNumber));
        return LoansMapper.mapToLoansDto(loans, new LoansDTO());
    }

    @Override
    public boolean updateLoan(LoansDTO loansDto) {
        Loans loans = loansRepository.findByLoanNumber(loansDto.getLoanNumber())
                .orElseThrow(() -> new ResourceNotFoundException(
                        LoansConstants.LOAN_RESOURCE, LoansConstants.LOAN_RESOURCE_LOAN_NUMBER_FIELD, loansDto.getLoanNumber()));
        LoansMapper.mapToLoans(loansDto, loans);
        loansRepository.save(loans);
        return true;
    }

    @Override
    public boolean deleteLoan(String mobileNumber) {
        Loans loans = loansRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException(
                        LoansConstants.LOAN_RESOURCE, LoansConstants.LOAN_RESOURCE_MOBILE_FIELD, mobileNumber));
        loansRepository.deleteById(loans.getLoanId());
        return true;
    }
}