package com.coderboost.propertyservice.repo;

import com.coderboost.propertyservice.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepo extends JpaRepository<Owner, Long> {
}
