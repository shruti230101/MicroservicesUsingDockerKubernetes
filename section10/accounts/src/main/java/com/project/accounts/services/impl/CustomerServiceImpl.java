package com.project.accounts.services.impl;

import com.project.accounts.constants.AccountsConstants;
import com.project.accounts.constants.CustomerConstants;
import com.project.accounts.dtos.AccountsDTO;
import com.project.accounts.dtos.CardsDTO;
import com.project.accounts.dtos.CustomerDetailsDTO;
import com.project.accounts.dtos.LoansDTO;
import com.project.accounts.entities.Accounts;
import com.project.accounts.entities.Customer;
import com.project.accounts.exceptions.ResourceNotFoundException;
import com.project.accounts.mapper.AccountsMapper;
import com.project.accounts.mapper.CustomerMapper;
import com.project.accounts.repositories.AccountsRepository;
import com.project.accounts.repositories.CustomerRepository;
import com.project.accounts.services.ICustomerService;
import com.project.accounts.services.client.CardsFeignClient;
import com.project.accounts.services.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private CustomerRepository customerRepository;
    private AccountsRepository accountsRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    @Override
    public CustomerDetailsDTO fetchCustomerDetails(String mobileNumber, String correlationId) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException(CustomerConstants.CUSTOMER_RESOURCE_NAME,
                        CustomerConstants.CUSTOMER_RESOURCE_FIELD, mobileNumber));
        Accounts account = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException(AccountsConstants.ACCOUNTS_RESOURCE_NAME,
                        AccountsConstants.ACCOUNTS_RESOURCE_FIELD, customer.getCustomerId().toString()));

        CustomerDetailsDTO customerDetailsDTO = CustomerMapper.mapToCustomerDetailsDTO(customer, new CustomerDetailsDTO());
        customerDetailsDTO.setAccountsDTO(AccountsMapper.mapToAccountsDTO(account, new AccountsDTO()));

        ResponseEntity<LoansDTO> loansDTOResponseEntity = loansFeignClient.fetchLoanDetails(correlationId, mobileNumber);
        if(null != loansDTOResponseEntity) {
            customerDetailsDTO.setLoansDTO(loansDTOResponseEntity.getBody());
        }

        ResponseEntity<CardsDTO> cardsDTOResponseEntity = cardsFeignClient.fetchCardDetails(correlationId, mobileNumber);
        if(null != cardsDTOResponseEntity) {
            customerDetailsDTO.setCardsDTO(cardsDTOResponseEntity.getBody());
        }

        return customerDetailsDTO;
    }
}
