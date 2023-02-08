package com.coderboost.propertyservice.service;

import com.coderboost.propertyservice.dto.CustomerDto;
import com.coderboost.propertyservice.dto.response.PropertyOfferDto;

import java.util.List;

public interface CustomerService {

    void saveCustomer(CustomerDto newCustomer);

    CustomerDto getCustomerByUserId(long userId);

    List<CustomerDto> getAllCustomers();

    List<PropertyOfferDto> getCustomerOffers(long id);
}
