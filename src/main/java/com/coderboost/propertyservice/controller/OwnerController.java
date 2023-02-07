package com.coderboost.propertyservice.controller;

import com.coderboost.propertyservice.dto.response.OwnerDto;
import com.coderboost.propertyservice.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/owners")
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public List<OwnerDto> getAllOwners(){
        return ownerService.getAllOwners();
    }

    @GetMapping("/{id}")
    public List<OwnerDto> getOwnerDetails(@PathVariable long id){
        return ownerService.getAllOwners();
    }



}
