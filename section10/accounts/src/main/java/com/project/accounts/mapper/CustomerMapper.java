package com.project.accounts.mapper;

import com.project.accounts.dtos.CustomerDTO;
import com.project.accounts.dtos.CustomerDetailsDTO;
import com.project.accounts.entities.Customer;

public class CustomerMapper {

    public static CustomerDTO mapToCustomerDTO(Customer customer, CustomerDTO customerDTO) {
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setMobileNumber(String.valueOf(customer.getMobileNumber()));
        return customerDTO;
    }

    public static CustomerDetailsDTO mapToCustomerDetailsDTO(Customer customer, CustomerDetailsDTO customerDetailsDTO) {
        customerDetailsDTO.setName(customer.getName());
        customerDetailsDTO.setEmail(customer.getEmail());
        customerDetailsDTO.setMobileNumber(customer.getMobileNumber());
        return customerDetailsDTO;
    }

    public static Customer mapToCustomer(CustomerDTO customerDTO, Customer customer) {
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setMobileNumber(String.valueOf(customerDTO.getMobileNumber()));
        return customer;
    }
}
