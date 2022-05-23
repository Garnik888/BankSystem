package com.example.banksystem.service;

import com.example.banksystem.domain.entity.Account;
import com.example.banksystem.mappers.ModelMapperConfig;
import com.example.banksystem.repository.AccountRepo;

import java.util.Optional;

public class AccountService {

    private ModelMapperConfig modelMapperConfig;
    private AccountRepo accountRepo;

    public AccountService(ModelMapperConfig modelMapperConfig, AccountRepo accountRepo) {
        this.modelMapperConfig = modelMapperConfig;
        this.accountRepo = accountRepo;
    }


}
