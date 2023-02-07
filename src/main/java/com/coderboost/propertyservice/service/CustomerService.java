package com.coderboost.propertyservice.service;

import com.coderboost.propertyservice.dto.CustomerDto;

public interface CustomerService {

    void saveCustomer(CustomerDto newCustomer);

    CustomerDto getCustomerByUserId(long userId);
}
