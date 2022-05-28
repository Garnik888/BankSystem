package com.example.banksystem.dto.request;

import com.example.banksystem.domain.entity.CardHolder;
import com.example.banksystem.domain.entity.IssuerBranch;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountRequestDto {

    private String IBAN;
    private String accountBalance;

    @JsonProperty("issuer")
    private IssuerBranchRequestDto issuerBranch;
    @JsonProperty("cardHolder")
    private CardHolderRequestDto cardHolder;

    public AccountRequestDto() {

    }

    public AccountRequestDto(String IBAN, String accountBalance,
                             IssuerBranchRequestDto issuerBranch,
                             CardHolderRequestDto cardHolder) {
        this.IBAN = IBAN;
        this.accountBalance = accountBalance;
        this.issuerBranch = issuerBranch;
        this.cardHolder = cardHolder;
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

    public IssuerBranchRequestDto getIssuerBranch() {
        return issuerBranch;
    }

    public void setIssuerBranch(IssuerBranchRequestDto issuerBranch) {
        this.issuerBranch = issuerBranch;
    }

    public CardHolderRequestDto getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(CardHolderRequestDto cardHolder) {
        this.cardHolder = cardHolder;
    }
}
