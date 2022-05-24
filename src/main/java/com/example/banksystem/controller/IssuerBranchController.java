package com.example.banksystem.controller;

import com.example.banksystem.dto.IssuerBranchDto;
import com.example.banksystem.service.IssuerBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/issuer")
public class IssuerBranchController {

    private final IssuerBranchService issuerBranchService;

    @Autowired
    public IssuerBranchController(IssuerBranchService issuerBranchService) {
        this.issuerBranchService = issuerBranchService;
    }

    @PostMapping
    public ResponseEntity<?> createIssuerBranch(@RequestBody IssuerBranchDto issuerBranchDto) {

        IssuerBranchDto issuerBranchDtoSave = issuerBranchService.save(issuerBranchDto);

        if (issuerBranchDtoSave == null) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.ok(issuerBranchDtoSave);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getIssuerBranchById(@PathVariable("id") Long id) {

        IssuerBranchDto issuerBranchDto = issuerBranchService.getIssuerById(id);

        if (issuerBranchDto != null) {

            return ResponseEntity.ok(issuerBranchDto);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).
                body("Issuer branch with given properties does not exist.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateIssuerBranchById(@PathVariable("id") Long id,
                                                    @RequestBody IssuerBranchDto issuerBranchDto) {

        IssuerBranchDto issuerBranchDtoUpdate = issuerBranchService.updateIssuerBranchById(id, issuerBranchDto);

        if (issuerBranchDtoUpdate != null) {

            return ResponseEntity.ok(issuerBranchDtoUpdate);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).
                body("Issuer branch with given properties does not exist.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteIssuerBranchById(@PathVariable("id") Long id) {

        IssuerBranchDto issuerBranchDto = issuerBranchService.deleteIssuerBranchById(id);

        if (issuerBranchDto != null) {

            return ResponseEntity.ok(issuerBranchDto);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).
                body("Issuer branch with given properties does not exist.");
    }
}