package com.coderboost.propertyservice.service.Impl;

import com.coderboost.propertyservice.dto.CustomerDto;
import com.coderboost.propertyservice.entity.Customer;
import com.coderboost.propertyservice.mapper.CustomerMapper;
import com.coderboost.propertyservice.repo.CustomerRepo;
import com.coderboost.propertyservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public void saveCustomer(CustomerDto newCustomerDto) {

        Optional<Customer> customer = customerRepo.findByUserId(newCustomerDto.getUserId());
        if (!customer.isPresent()) {
            Customer newCustomer = CustomerMapper.toEntity(newCustomerDto);
            customerRepo.save(newCustomer);
        } else
            throw new RuntimeException("Customer with userID " + newCustomerDto.getUserId() + " already exists");
    }

    @Override
    public CustomerDto getCustomerByUserId(long userId) {
        Optional<Customer> customer = customerRepo.findByUserId(userId);
        return customer.isPresent() ? CustomerMapper.toDto(customer.get()) : new CustomerDto();
    }
}
