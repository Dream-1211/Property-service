package com.coderboost.propertyservice.controller;

import com.coderboost.propertyservice.dto.request.NewOwnerDto;
import com.coderboost.propertyservice.dto.request.ReviewOwnerDto;
import com.coderboost.propertyservice.dto.response.OwnerDetailsDto;
import com.coderboost.propertyservice.dto.response.OwnerDto;
import com.coderboost.propertyservice.dto.response.PropertyOfferDto;
import com.coderboost.propertyservice.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/owners")
@CrossOrigin(origins = {"http://localhost:3000"})
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<OwnerDto> getAllOwners() {
        return ownerService.getAllOwners();
    }



    @PreAuthorize("hasAuthority('OWNER') OR hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public OwnerDetailsDto getOwnerDetails(@PathVariable long id) {
        return ownerService.getOwnerDetailsById(id);
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping()
    public void updateOwnerStatus(@RequestBody ReviewOwnerDto reviewOwnerDto) {
        ownerService.updateOwnerStatus(reviewOwnerDto.getId(), reviewOwnerDto.getStatus());
    }

    @PreAuthorize("hasAuthority('OWNER')")
    @GetMapping("/userid/{userId}")
    public OwnerDto getOwnerByUserId(@PathVariable long userId) {
        return ownerService.getOwnerByUserId(userId);
    }

    @GetMapping("/{id}/properties/{pid}/offers")
    public List<PropertyOfferDto> getAllOffersByOwnerAndProperty(@PathVariable long id, @PathVariable long pid) {
        return ownerService.getOwnerPropertyAllOffers(id, pid);
    }

    @PostMapping
    public void addNewOwner(@RequestBody NewOwnerDto ownerDto) {
        ownerService.saveOwner(ownerDto);
    }


}

