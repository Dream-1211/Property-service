package com.coderboost.propertyservice.repo;

import com.coderboost.propertyservice.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepo extends JpaRepository<Property, Long> {
}
