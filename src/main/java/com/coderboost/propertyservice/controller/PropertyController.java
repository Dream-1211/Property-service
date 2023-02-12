package com.coderboost.propertyservice.controller;

import com.coderboost.propertyservice.dto.request.PropertyCreateDto;
import com.coderboost.propertyservice.dto.response.PropertyDetailsDto;
import com.coderboost.propertyservice.enums.PropertyStatus;
import com.coderboost.propertyservice.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
@CrossOrigin(origins = {"http://localhost:3000"})
public class PropertyController {
    private final PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping
    public List<PropertyDetailsDto> fetchProperties() {
        return propertyService.fetchProperties();
    }

    @PreAuthorize("hasAuthority('OWNER')")
    @PostMapping
    public void addNewProperty(@RequestBody PropertyCreateDto propertyCreateDto) {
        propertyService.addProperty(propertyCreateDto);
    }

    @PreAuthorize("hasAuthority('OWNER') OR hasAuthority('CUSTOMER')")
    @GetMapping("/{id}")
    public PropertyDetailsDto fetchPropertyById(@PathVariable long id) {
        return propertyService.fetchPropertyById(id);
    }

    @PreAuthorize("hasAuthority('OWNER')")
    @PutMapping("/{id}")
    public void updatePropertyStatus(@PathVariable long id, @RequestBody PropertyStatus propertyStatus) {
        propertyService.updatePropertyStatus(id, propertyStatus);
    }

    @PreAuthorize("hasAuthority('OWNER')")
    @DeleteMapping("/{id}")
    public void deleteProperty(@PathVariable long id) {
        propertyService.deleteProperty(id);
    }
}
