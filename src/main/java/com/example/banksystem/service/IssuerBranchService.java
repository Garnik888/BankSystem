package com.example.banksystem.service;

import com.example.banksystem.domain.entity.Address;
import com.example.banksystem.domain.entity.IssuerBranch;
import com.example.banksystem.dto.request.AddressRequestDto;
import com.example.banksystem.dto.request.IssuerBranchRequestDto;
import com.example.banksystem.dto.response.IssuerBranchResponseDto;
import com.example.banksystem.repository.IssuerBranchRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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

    public IssuerBranchResponseDto save(IssuerBranchRequestDto issuerBranchRequestDto) {

        IssuerBranch issuerBranch = this.modelMapper.map(issuerBranchRequestDto, IssuerBranch.class);

        return this.modelMapper.map(this.issuerBranchRepo.save(issuerBranch), IssuerBranchResponseDto.class);
    }

    public IssuerBranchResponseDto getIssuerById(Long id) {

        Optional<IssuerBranch> issuerBranch = this.issuerBranchRepo.findById(id);

        if (issuerBranch.isPresent()) {

            return this.modelMapper.map(issuerBranch, IssuerBranchResponseDto.class);
        }

        return null;
    }

    public IssuerBranchResponseDto updateIssuerBranchById(Long id, IssuerBranchRequestDto issuerBranchRequestDto) {

        Optional<IssuerBranch> issuerBranchUpdate = issuerBranchRepo.findById(id);

        IssuerBranch issuerBranch = modelMapper.map(issuerBranchUpdate, IssuerBranch.class);

        if (issuerBranchUpdate.isPresent()) {
            issuerBranch.setBankName(issuerBranchRequestDto.getBankName());
            issuerBranch.setBankCode(issuerBranchRequestDto.getBankCode());
            issuerBranch.setIssuerType(issuerBranchRequestDto.getIssuerType());

            return modelMapper.map(issuerBranchRepo.save(issuerBranch), IssuerBranchResponseDto.class);
        }

        return null;
    }

    public IssuerBranchResponseDto deleteIssuerBranchById(Long id) {

        Optional<IssuerBranch> issuerBranchDelete = issuerBranchRepo.findById(id);
        IssuerBranch issuerBranch = modelMapper.map(issuerBranchDelete, IssuerBranch.class);

        if (issuerBranchDelete.isPresent()) {

            issuerBranchRepo.delete(issuerBranch);
            return modelMapper.map(issuerBranch, IssuerBranchResponseDto.class);
        }

        return null;
    }

    public Optional<IssuerBranch> getIssuerBranch(IssuerBranchRequestDto issuerBranchRequestDto) {

        IssuerBranch issuerBranchGet = modelMapper.map(issuerBranchRequestDto, IssuerBranch.class);
        Example<IssuerBranch> example = Example.of(issuerBranchGet);
        Optional<IssuerBranch> issuerBranch = issuerBranchRepo.findOne(example);

        return issuerBranch;
    }
}
