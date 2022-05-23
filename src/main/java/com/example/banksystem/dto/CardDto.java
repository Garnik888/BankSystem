package com.example.banksystem.dto;

import com.example.banksystem.domain.enum_types.BalanceType;
import com.example.banksystem.domain.enum_types.CardStatus;
import com.example.banksystem.domain.enum_types.CardType;

import javax.persistence.Column;
import java.time.LocalDate;

public class CardDto {

    private CardType cardType;
    private BalanceType balanceType;
    private String balance;
    private String cardNumber;
    private LocalDate expirationDate;
    private String CVC;
    private CardStatus cardStatus;
    private String PIN;

    public CardDto() {

    }

    public CardDto(CardType cardType, BalanceType balanceType,
                   String balance, String cardNumber,
                   LocalDate expirationDate, String CVC,
                   CardStatus cardStatus, String PIN) {
        this.cardType = cardType;
        this.balanceType = balanceType;
        this.balance = balance;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.CVC = CVC;
        this.cardStatus = cardStatus;
        this.PIN = PIN;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public BalanceType getBalanceType() {
        return balanceType;
    }

    public void setBalanceType(BalanceType balanceType) {
        this.balanceType = balanceType;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCVC() {
        return CVC;
    }

    public void setCVC(String CVC) {
        this.CVC = CVC;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }
}
