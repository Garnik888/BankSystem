package com.example.banksystem.service;

import com.example.banksystem.domain.entity.Account;
import com.example.banksystem.mappers.ModelMapperConfig;
import com.example.banksystem.repository.AccountRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    private ModelMapper modelMapper;
    private AccountRepo accountRepo;

    @Autowired
    public AccountService(ModelMapper modelMapper, AccountRepo accountRepo) {
        this.modelMapper = modelMapper;
        this.accountRepo = accountRepo;
    }
}
