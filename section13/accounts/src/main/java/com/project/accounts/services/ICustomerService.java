package com.project.accounts.services;

import com.project.accounts.dtos.CustomerDetailsDTO;

public interface ICustomerService {
    CustomerDetailsDTO fetchCustomerDetails(String mobileNumber, String correlationId);
}
