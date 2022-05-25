package com.example.banksystem.repository;

import com.example.banksystem.domain.entity.IssuerBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssuerBranchRepo extends JpaRepository<IssuerBranch, Long> {

}
