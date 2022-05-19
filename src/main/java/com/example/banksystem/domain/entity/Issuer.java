package com.example.banksystem.domain.entity;

import com.example.banksystem.domain.enum_types.IssuerType;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class Issuer {

    private String bankName;
    private String bankCode;
    private IssuerType issuerType;

    public Issuer() {

        this.bankName = "UCO Bank";
        this.bankCode = "UCBA012345";
        this.issuerType = IssuerType.COMMERCIAL_BANK;
    }
}
