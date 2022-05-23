package com.example.banksystem.repository;

import com.example.banksystem.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface AccountRepo extends JpaRepository<Account, Long> {

    boolean existsByIBAN(String iban);
}
