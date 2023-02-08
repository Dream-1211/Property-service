package com.coderboost.propertyservice.controller;

import com.coderboost.propertyservice.dto.CustomerDto;
import com.coderboost.propertyservice.dto.response.PropertyOfferDto;
import com.coderboost.propertyservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {


    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void addNewCustomer(@RequestBody CustomerDto newCustomer) {
        customerService.saveCustomer(newCustomer);
    }

    @GetMapping
    public List<CustomerDto> getAllCustomers() {
       return customerService.getAllCustomers();
    }

    @GetMapping("/userid/{userId}")
    public CustomerDto getCustomerByUserId(@PathVariable long userId) {
        return customerService.getCustomerByUserId(userId);
    }

    @GetMapping("/{id}/offers")
    public List<PropertyOfferDto> getCustomerOffers(@PathVariable long id){
        return customerService.getCustomerOffers(id);
    }
}
