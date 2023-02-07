package com.coderboost.propertyservice.service;

import com.coderboost.propertyservice.dto.request.NewCustomer;

public interface CustomerService {

    void saveCustomer(NewCustomer newCustomer);
}
