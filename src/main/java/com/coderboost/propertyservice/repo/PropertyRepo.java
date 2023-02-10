package com.coderboost.propertyservice.repo;

import com.coderboost.propertyservice.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PropertyRepo extends JpaRepository<Property, Long> {

    Optional<Property> findByIdAndIsActive(long id, boolean isActive);

    List<Property> findAllByIsActive(boolean isActive);
}
