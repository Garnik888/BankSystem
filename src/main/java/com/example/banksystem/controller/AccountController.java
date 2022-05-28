package com.example.banksystem.controller;

import com.example.banksystem.dto.request.AccountRequestDto;
import com.example.banksystem.dto.response.AccountResponseDto;
import com.example.banksystem.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<?> saveAccount(@RequestBody AccountRequestDto accountRequestDto) throws Exception {

        AccountResponseDto accountResponseDto = accountService.saveAccount(accountRequestDto);

        if (accountResponseDto != null) {

            return ResponseEntity.ok(accountResponseDto);
        }

        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Account is not save");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAccount(@PathVariable("id") Long id,
                                           @RequestBody AccountRequestDto accountRequestDto) throws Exception {

        AccountResponseDto accountResponseDto = accountService.updateAccount(id, accountRequestDto);

        if(accountResponseDto != null) {

            return ResponseEntity.ok(accountResponseDto);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account is not found");
    }
}
