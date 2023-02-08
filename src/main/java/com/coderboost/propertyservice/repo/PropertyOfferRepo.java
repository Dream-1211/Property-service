package com.coderboost.propertyservice.repo;

import com.coderboost.propertyservice.entity.PropertyOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyOfferRepo extends JpaRepository<PropertyOffer, Long> {

    List<PropertyOffer> findByOwnerIdAndPropertyId(long id, long pid);
}
