package com.coderboost.propertyservice.repo;

import com.coderboost.propertyservice.entity.PropertyOffers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyOfferRepo extends JpaRepository<PropertyOffers, Long> {

    List<PropertyOffers> findByOwnerIdAndPropertyId(long id, long pid);
}
