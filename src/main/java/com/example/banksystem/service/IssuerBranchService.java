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

        IssuerBranch issuerBranch = this.modelMapper.map(issuerBranchDto, IssuerBranch.class);

        return this.modelMapper.map(this.issuerBranchRepo.save(issuerBranch), IssuerBranchDto.class);
    }

    public IssuerBranchDto getIssuerById(Long id) {

        Optional<IssuerBranch> issuerBranch = this.issuerBranchRepo.findById(id);

        if (issuerBranch.isPresent()) {

            return this.modelMapper.map(issuerBranch, IssuerBranchDto.class);
        }

        return null;
    }

    public IssuerBranchDto updateIssuerBranchById(Long id, IssuerBranchDto issuerBranchDto) {

        Optional<IssuerBranch> issuerBranchUpdate = issuerBranchRepo.findById(id);

        IssuerBranch issuerBranch = modelMapper.map(issuerBranchUpdate, IssuerBranch.class);

        if (issuerBranchUpdate.isPresent()) {
            issuerBranch.setBankName(issuerBranchDto.getBankName());
            issuerBranch.setBankCode(issuerBranchDto.getBankCode());
            issuerBranch.setIssuerType(issuerBranchDto.getIssuerType());

            return modelMapper.map(issuerBranchRepo.save(issuerBranch), IssuerBranchDto.class);
        }

        return null;
    }

    public IssuerBranchDto deleteIssuerBranchById(Long id) {

        Optional<IssuerBranch> issuerBranchDelete = issuerBranchRepo.findById(id);
        IssuerBranch issuerBranch = modelMapper.map(issuerBranchDelete, IssuerBranch.class);

        if (issuerBranchDelete.isPresent()) {

            issuerBranchRepo.delete(issuerBranch);
            return modelMapper.map(issuerBranch, IssuerBranchDto.class);
        }

        return null;
    }
}
