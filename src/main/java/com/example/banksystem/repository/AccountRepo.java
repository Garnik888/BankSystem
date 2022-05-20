package com.example.banksystem.repository;

import com.example.banksystem.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {

}
