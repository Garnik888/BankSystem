package com.example.banksystem.controller;

import com.example.banksystem.domain.entity.Card;
import com.example.banksystem.domain.entity.CardHolder;
import com.example.banksystem.dto.request.AddressRequestDto;
import com.example.banksystem.dto.request.CardHolderAddressRequestDto;
import com.example.banksystem.dto.request.CardHolderRequestDto;
import com.example.banksystem.dto.response.AddressResponseDto;
import com.example.banksystem.dto.response.CardHolderAddressResponseDto;
import com.example.banksystem.dto.response.CardHolderResponseDto;
import com.example.banksystem.service.CardHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class CardHolderController {

    private final CardHolderService cardHolderService;

    @Autowired
    public CardHolderController(CardHolderService cardHolderService) {
        this.cardHolderService = cardHolderService;
    }

    @PostMapping
    public ResponseEntity<?> createCardHolder(@RequestBody CardHolderAddressRequestDto
                                                          cardHolderAddressRequestDto) {

        CardHolderResponseDto cardHolderResponseDto =
                cardHolderService.saveCardHolder(cardHolderAddressRequestDto);

        if (cardHolderResponseDto == null) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.ok(cardHolderResponseDto);
    }
}
