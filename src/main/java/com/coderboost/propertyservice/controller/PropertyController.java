package com.coderboost.propertyservice.controller;

import com.coderboost.propertyservice.dto.request.PropertyCreateDto;
import com.coderboost.propertyservice.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {
    private final PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping
    public void addNewProperty(@RequestBody PropertyCreateDto propertyCreateDto) {
        propertyService.addProperty(propertyCreateDto);
    }
}
