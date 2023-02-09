package com.coderboost.propertyservice.mapper;

import com.coderboost.propertyservice.dto.CustomerDto;
import com.coderboost.propertyservice.entity.Customer;

import java.util.List;


public class CustomerMapper {

    public static CustomerDto toDto(Customer customer) {
        return new CustomerDto(customer.getId(), customer.getName(), customer.getUserId());
    }

    public static Customer toEntity(CustomerDto customerDto) {
        return new Customer(customerDto.getName(), customerDto.getUserId());
    }

    public static List<CustomerDto> toListDto(List<Customer> customerList) {
        return customerList.stream().map(CustomerMapper::toDto).toList();
    }

}
