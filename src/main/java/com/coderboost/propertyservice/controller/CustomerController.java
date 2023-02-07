package com.coderboost.propertyservice.controller;

import com.coderboost.propertyservice.dto.request.NewCustomer;
import com.coderboost.propertyservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {


    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void addNewCustomer(@RequestBody NewCustomer newCustomer) {
        customerService.saveCustomer(newCustomer);
    }


}
