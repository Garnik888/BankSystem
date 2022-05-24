package com.example.banksystem.service;

import com.example.banksystem.domain.entity.IssuerBranch;
import com.example.banksystem.dto.IssuerBranchDto;
import com.example.banksystem.repository.IssuerBranchRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IssuerBranchService {

    private ModelMapper modelMapper;
    private IssuerBranchRepo issuerBranchRepo;

    @Autowired
    public IssuerBranchService(ModelMapper modelMapper, IssuerBranchRepo issuerBranchRepo) {
        this.modelMapper = modelMapper;
        this.issuerBranchRepo = issuerBranchRepo;
    }

    public IssuerBranchDto save(IssuerBranchDto issuerBranchDto) {

        IssuerBranch issuerBranch = modelMapper.map(issuerBranchDto, IssuerBranch.class);

        return modelMapper.map(issuerBranchRepo.save(issuerBranch), IssuerBranchDto.class);
    }

    public IssuerBranchDto getIssuerById(Long id) {

        Optional<IssuerBranch> issuerBranch = issuerBranchRepo.findById(id);

        if (issuerBranch.isPresent()) {

            return null;
        }

        return modelMapper.map(issuerBranch, IssuerBranchDto.class);
    }

    public IssuerBranchDto updateIssuerBranchById(Long id, IssuerBranchDto issuerBranchDto) {

        IssuerBranch issuerBranch = modelMapper.map(issuerBranchRepo.findById(id), IssuerBranch.class);
        if (issuerBranch == null) {
            return null;
        }

        issuerBranch.setBankName(issuerBranchDto.getBankName());
        issuerBranch.setBankCode(issuerBranchDto.getBankCode());
        issuerBranch.setIssuerType(issuerBranchDto.getIssuerType());

        return modelMapper.map(issuerBranchRepo.save(issuerBranch), IssuerBranchDto.class);
    }
}
