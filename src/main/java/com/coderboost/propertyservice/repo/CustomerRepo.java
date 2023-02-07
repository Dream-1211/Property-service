package com.coderboost.propertyservice.repo;

import com.coderboost.propertyservice.service.CustomerService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<CustomerService, Long> {
}
