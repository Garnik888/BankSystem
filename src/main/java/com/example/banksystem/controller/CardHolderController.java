package com.example.banksystem.controller;

import com.example.banksystem.dto.request.CardHolderAddressRequestDto;
import com.example.banksystem.dto.response.CardHolderAddressResponseDto;
import com.example.banksystem.dto.response.CardHolderResponseDto;
import com.example.banksystem.service.CardHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        CardHolderAddressResponseDto holderResponseDto =
                cardHolderService.saveCardHolder(cardHolderAddressRequestDto);

        if (holderResponseDto == null) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.ok(holderResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCardHolder(@RequestBody CardHolderAddressRequestDto
                                                      cardHolderAddressRequestDto,
                                              @PathVariable("id") Long id) {

        CardHolderAddressResponseDto cardHolderAddressResponseDto = cardHolderService.
                updateCardHolder(id,  cardHolderAddressRequestDto);

        if(cardHolderAddressResponseDto != null) {

            return ResponseEntity.ok(cardHolderAddressResponseDto);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).
                body("Card holder with given properties does not exist.");
    }

}
