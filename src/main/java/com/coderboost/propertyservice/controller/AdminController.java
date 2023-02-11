package com.coderboost.propertyservice.controller;

import com.coderboost.propertyservice.dto.request.OfferCreateDto;
import com.coderboost.propertyservice.dto.response.AdminStatisticsDto;
import com.coderboost.propertyservice.enums.OfferStatus;
import com.coderboost.propertyservice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
@CrossOrigin(origins = {"http://localhost:3000"})
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/dashboard")
    public AdminStatisticsDto getStatistics() {
        return adminService.getCustomerOwnerAndPropertyStatistics();
    }

}
