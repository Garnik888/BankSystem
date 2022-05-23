package com.example.banksystem.dto;

import javax.persistence.Column;

public class AccountDto {

    private String IBAN;
    private String accountBalance;

    public AccountDto() {

    }

    public AccountDto(String IBAN, String accountBalance) {
        this.IBAN = IBAN;
        this.accountBalance = accountBalance;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }
}
