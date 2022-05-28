package com.example.banksystem.controller;

import com.example.banksystem.domain.entity.Address;
import com.example.banksystem.dto.request.AddressRequestDto;
import com.example.banksystem.dto.response.AddressResponseDto;
import com.example.banksystem.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    private final ModelMapper modelMapper;

    @Autowired
    public AddressController(AddressService addressService, ModelMapper modelMapper) {
        this.addressService = addressService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<?> createAddress(@RequestBody AddressRequestDto addressRequestDto) {

        AddressResponseDto addressResponseDto =
                addressService.saveAddress(addressRequestDto);

        if (addressResponseDto == null) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.ok(addressResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAddressById(@PathVariable("id") Long id,
                                               @RequestBody AddressRequestDto addressRequestDto) {

        AddressResponseDto addressResponseDto = addressService.
                updateAddressById(id, addressRequestDto);

        if (addressResponseDto != null) {

            return ResponseEntity.ok(addressResponseDto);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).
                body("Issuer branch with given properties does not exist.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddressById(@PathVariable("id") Long id) {

        AddressResponseDto addressResponseDto = addressService.deleteAddressById(id);

        if (addressResponseDto != null) {

            return ResponseEntity.ok(addressResponseDto);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).
                body("Issuer branch with given properties does not exist.");
    }

    @GetMapping
    public ResponseEntity<?> getAddressRequestDto(@RequestBody AddressRequestDto addressRequestDto) {

        Optional<Address> address = addressService.getAddress(addressRequestDto);

        AddressResponseDto addressGet = modelMapper.map(address, AddressResponseDto.class);

        if (address.isPresent()) {

            return ResponseEntity.ok(addressGet);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).
                body("Address branch with given properties does not found.");
    }
}
