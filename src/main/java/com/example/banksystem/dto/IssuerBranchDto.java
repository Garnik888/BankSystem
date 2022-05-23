package com.example.banksystem.dto;

import com.example.banksystem.domain.enum_types.IssuerType;

import javax.persistence.Column;

public class IssuerBranchDto {

    private String bankName;
    private String bankCode;
    private IssuerType issuerType;

    public IssuerBranchDto() {

    }

    public IssuerBranchDto(String bankName, String bankCode, IssuerType issuerType) {
        this.bankName = bankName;
        this.bankCode = bankCode;
        this.issuerType = issuerType;
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
}
