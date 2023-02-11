package com.coderboost.propertyservice.controller;

import com.coderboost.propertyservice.dto.request.OfferCreateDto;
import com.coderboost.propertyservice.enums.OfferStatus;
import com.coderboost.propertyservice.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/offers")
@CrossOrigin(origins = {"http://localhost:3000"})
public class OfferController {
    private final OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @PreAuthorize("hasAuthority('CUSTOMER')")
    @PostMapping
    public void addNewOffer(@RequestBody OfferCreateDto offerCreateDto) {
        offerService.addNewOffer(offerCreateDto);
    }

    @PreAuthorize("hasAuthority('OWNER') OR hasAuthority('CUSTOMER')")
    @PutMapping("/{id}")
    public void updateOfferStatus(@PathVariable long id, @RequestBody OfferStatus offerStatus) {
        offerService.updateOfferStatus(id, offerStatus);
    }
}
