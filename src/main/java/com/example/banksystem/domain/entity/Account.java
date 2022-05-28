package com.example.banksystem.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("iban")
    @Column(name = "iban", nullable = false, unique = true)
    private String IBAN;
    @Column(name = "account_balance", nullable = false)
    private String accountBalance;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,
            CascadeType.REFRESH, CascadeType.MERGE} )
    @JoinColumn(name = "id_issuer_branch", nullable = false,
            foreignKey = @ForeignKey(name = "issuer_branch_account_fk"))
    private IssuerBranch issuerBranch;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,
            CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "id_card_holder", nullable = false,
            foreignKey = @ForeignKey(name = "card_holder_account_fk"))
    private CardHolder cardHolder;

    public Account() {

    }

    public Account(Long id, String IBAN, String accountBalance,
                   IssuerBranch issuerBranch, CardHolder cardHolder) {
        this.id = id;
        this.IBAN = IBAN;
        this.accountBalance = accountBalance;
        this.issuerBranch = issuerBranch;
        this.cardHolder = cardHolder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public IssuerBranch getIssuerBranch() {
        return issuerBranch;
    }

    public void setIssuerBranch(IssuerBranch issuerBranch) {
        this.issuerBranch = issuerBranch;
    }

    public CardHolder getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(CardHolder cardHolder) {
        this.cardHolder = cardHolder;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", IBAN='" + IBAN + '\'' +
                ", accountBalance='" + accountBalance + '\'' +
                '}';
    }
}
