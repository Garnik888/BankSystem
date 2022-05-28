package com.example.banksystem.service;

import com.example.banksystem.domain.entity.Account;
import com.example.banksystem.domain.entity.CardHolder;
import com.example.banksystem.domain.entity.IssuerBranch;
import com.example.banksystem.dto.request.AccountRequestDto;
import com.example.banksystem.dto.request.AddressRequestDto;
import com.example.banksystem.dto.request.CardHolderRequestDto;
import com.example.banksystem.dto.request.IssuerBranchRequestDto;
import com.example.banksystem.dto.response.AccountResponseDto;
import com.example.banksystem.mappers.ModelMapperConfig;
import com.example.banksystem.repository.AccountRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    private final ModelMapper modelMapper;
    private final AccountRepo accountRepo;
    private final IssuerBranchService issuerBranchService;
    private final CardHolderService cardHolderService;

    public AccountService(ModelMapper modelMapper, AccountRepo accountRepo,
                          IssuerBranchService issuerBranchService,
                          CardHolderService cardHolderService) {

        this.modelMapper = modelMapper;
        this.accountRepo = accountRepo;
        this.issuerBranchService = issuerBranchService;
        this.cardHolderService = cardHolderService;
    }

    public AccountResponseDto saveAccount(AccountRequestDto accountRequestDto) throws Exception {

        Account account = modelMapper.map(accountRequestDto, Account.class);

        getAndSaveAccount(accountRequestDto, account);

        return modelMapper.map(accountRepo.save(account), AccountResponseDto.class);
    }

    public AccountResponseDto updateAccount(Long id, AccountRequestDto accountRequestDto) throws Exception {

        Optional<Account> accountGet = accountRepo.findById(id);

        Account account = modelMapper.map(accountGet, Account.class);

        getAndSaveAccount(accountRequestDto, account);

        return modelMapper.map(accountRepo.save(account), AccountResponseDto.class);
    }

    private void getAndSaveAccount(AccountRequestDto accountRequestDto, Account account) throws Exception {

        Optional<CardHolder> cardHolderGet = cardHolderService.getCardHolder(
                accountRequestDto.getCardHolder());

        if (cardHolderGet.isEmpty()) {

            throw new Exception("Not fund card holder");
        }

        account.setCardHolder(modelMapper.map(cardHolderGet, CardHolder.class));

        Optional<IssuerBranch> issuerBranchGet = issuerBranchService.getIssuerBranch(
                accountRequestDto.getIssuerBranch());

        if(issuerBranchGet.isEmpty()) {

            throw new Exception("Not fund issuer branch");
        }

        account.setIssuerBranch(modelMapper.map(issuerBranchGet, IssuerBranch.class));
    }
}
