package com.coderboost.propertyservice.repo;

import com.coderboost.propertyservice.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OwnerRepo extends JpaRepository<Owner, Long> {
    @Query("SELECT o FROM Owner o ORDER BY o.status DESC")
    List<Owner> findAllOwnersOrderByStatusDesc();

}
