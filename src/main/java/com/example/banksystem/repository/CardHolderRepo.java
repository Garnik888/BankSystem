package com.example.banksystem.repository;

import com.example.banksystem.domain.entity.CardHolder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardHolderRepo extends JpaRepository<CardHolder, Long> {

}
