package com.coderboost.propertyservice.service.Impl;

import com.coderboost.propertyservice.dto.request.NewCustomer;
import com.coderboost.propertyservice.entity.Address;
import com.coderboost.propertyservice.entity.Customer;
import com.coderboost.propertyservice.repo.CustomerRepo;
import com.coderboost.propertyservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public void saveCustomer(NewCustomer newCustomerDto) {

        Optional<Customer> customer = customerRepo.findByUserId(newCustomerDto.getUserId());
        if (!customer.isPresent()) {
            Address address = new Address(newCustomerDto.getStreet(), newCustomerDto.getZipCode(), newCustomerDto.getState(), newCustomerDto.getLatitude(), newCustomerDto.getLongitude());
            Customer newCustomer = new Customer(newCustomerDto.getName(), newCustomerDto.getUserId(), address);
            customerRepo.save(newCustomer);
        }else
            throw new RuntimeException("Customer with userID "+newCustomerDto.getUserId()+" already exists");
    }
}
