package com.example.banksystem.controller;

import com.example.banksystem.dto.request.IssuerBranchRequestDto;
import com.example.banksystem.dto.response.IssuerBranchResponseDto;
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
    public ResponseEntity<?> createIssuerBranch(@RequestBody IssuerBranchRequestDto issuerBranchRequestDto) {

        IssuerBranchResponseDto issuerBranchResponseDto = issuerBranchService.save(issuerBranchRequestDto);

        if (issuerBranchResponseDto == null) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.ok(issuerBranchResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getIssuerBranchById(@PathVariable("id") Long id) {

        IssuerBranchResponseDto issuerBranchResponseDto = issuerBranchService.getIssuerById(id);

        if (issuerBranchResponseDto != null) {

            return ResponseEntity.ok(issuerBranchResponseDto);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).
                body("Issuer branch with given properties does not exist.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateIssuerBranchById(@PathVariable("id") Long id,
                                                    @RequestBody IssuerBranchRequestDto issuerBranchRequestDto) {

        IssuerBranchResponseDto issuerBranchResponseDto = issuerBranchService.
                updateIssuerBranchById(id, issuerBranchRequestDto);

        if (issuerBranchResponseDto != null) {

            return ResponseEntity.ok(issuerBranchResponseDto);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).
                body("Issuer branch with given properties does not exist.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteIssuerBranchById(@PathVariable("id") Long id) {

        IssuerBranchResponseDto issuerBranchResponseDto = issuerBranchService.deleteIssuerBranchById(id);

        if (issuerBranchResponseDto != null) {

            return ResponseEntity.ok(issuerBranchResponseDto);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).
                body("Issuer branch with given properties does not exist.");
    }
}