package com.coderboost.propertyservice.mapper;

import com.coderboost.propertyservice.dto.CustomerDto;
import com.coderboost.propertyservice.entity.Address;
import com.coderboost.propertyservice.entity.Customer;

import java.util.ArrayList;
import java.util.List;


public class CustomerMapper {

    public static CustomerDto toDto(Customer customer) {
        return new CustomerDto(customer.getId(), customer.getName(), customer.getUserId(), customer.getAddress().getStreet(),
                customer.getAddress().getZipCode(), customer.getAddress().getState(), customer.getAddress().getLongitude(),
                customer.getAddress().getLatitude());
    }

    public static Customer toEntity(CustomerDto customerDto) {
        Address address = new Address( customerDto.getStreet(), customerDto.getZipCode(), customerDto.getState(), customerDto.getLatitude(), customerDto.getLongitude());
        return new Customer(customerDto.getName(), customerDto.getUserId(), address);
    }

    public static List<CustomerDto> toListDto(List<Customer> customerList) {
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer customer : customerList) {
            customerDtos.add(toDto(customer));
        }
        return customerDtos;
    }

}
