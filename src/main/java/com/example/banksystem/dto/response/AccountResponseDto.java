package com.example.banksystem.dto.response;

public class AccountResponseDto {

    private String IBAN;
    private String accountBalance;

    public AccountResponseDto() {

    }

    public AccountResponseDto(String IBAN, String accountBalance) {
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
