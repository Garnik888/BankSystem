package com.example.banksystem.repository;

import com.example.banksystem.domain.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepo extends JpaRepository<Card, Long> {

}
