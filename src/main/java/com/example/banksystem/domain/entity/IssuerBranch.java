package com.example.banksystem.domain.entity;

import com.example.banksystem.domain.enum_types.IssuerType;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "issuer_branche")
public class IssuerBranch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "bank_name", nullable = false)
    private String bankName;
    @Column(name = "bank_code", nullable = false)
    private String bankCode;
    @Column(name = "issuer_type", nullable = false)
    private IssuerType issuerType;

    @OneToMany(mappedBy = "issuerBranch", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Account> accountList = new ArrayList<>();

    @OneToMany(mappedBy = "issuerBranch", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Card> cardList = new ArrayList<>();

    public IssuerBranch() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public IssuerType getIssuerType() {
        return issuerType;
    }

    public void setIssuerType(IssuerType issuerType) {
        this.issuerType = issuerType;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IssuerBranch that = (IssuerBranch) o;
        return Objects.equals(id, that.id) && Objects.equals(bankName, that.bankName) && Objects.equals(bankCode, that.bankCode) && issuerType == that.issuerType && Objects.equals(accountList, that.accountList) && Objects.equals(cardList, that.cardList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bankName, bankCode, issuerType, accountList, cardList);
    }

    @Override
    public String toString() {
        return "IssuerBranch{" +
                "id=" + id +
                ", bankName='" + bankName + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", issuerType=" + issuerType +
                '}';
    }
}
