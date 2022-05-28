package com.example.banksystem.repository;

import com.example.banksystem.domain.entity.CardHolder;
import com.example.banksystem.domain.entity.IssuerBranch;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardHolderRepo extends JpaRepository<CardHolder, Long> {

    @Override
    <S extends CardHolder> Optional<S> findOne(Example<S> example);
}
