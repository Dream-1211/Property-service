package com.coderboost.propertyservice.repo;

import com.coderboost.propertyservice.entity.Customer;
import com.coderboost.propertyservice.entity.PropertyOffers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Optional<Customer> findByUserId(long userId);
    @Query("SELECT c.offer FROM Customer c WHERE c.id = :id")
    List<PropertyOffers> findPropertyOffersById(@Param("id") long id);
}
