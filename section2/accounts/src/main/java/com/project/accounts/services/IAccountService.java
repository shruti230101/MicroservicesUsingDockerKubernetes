package com.project.accounts.services;

import com.project.accounts.dtos.CustomerDTO;

public interface IAccountService {

    void createAccount(CustomerDTO customerDTO);
}
