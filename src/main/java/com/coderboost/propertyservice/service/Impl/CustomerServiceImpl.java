package com.coderboost.propertyservice.service.Impl;

import com.coderboost.propertyservice.dto.CustomerDto;
import com.coderboost.propertyservice.dto.response.PropertyOfferDto;
import com.coderboost.propertyservice.entity.Customer;
import com.coderboost.propertyservice.entity.PropertyOffer;
import com.coderboost.propertyservice.exceptions.UserNotFoundException;
import com.coderboost.propertyservice.mapper.CustomerMapper;
import com.coderboost.propertyservice.mapper.PropertyOfferMapper;
import com.coderboost.propertyservice.repo.CustomerRepo;
import com.coderboost.propertyservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        if (customer.isPresent())
        return CustomerMapper.toDto(customer.get());
        else throw new UserNotFoundException("Customer with userID "+userId+" does not exist.");
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepo.findAll();
        return CustomerMapper.toListDto(customers);
    }

    @Override
    public List<PropertyOfferDto> getCustomerOffers(long id) {
        List<PropertyOffer> propertyOffer = customerRepo.findPropertyOffersById(id);
        return PropertyOfferMapper.toListDto(propertyOffer);
    }
}
