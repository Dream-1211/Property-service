package com.coderboost.propertyservice.repo;

import com.coderboost.propertyservice.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OwnerRepo extends JpaRepository<Owner, Long> {
    @Query("SELECT o FROM Owner o ORDER BY o.status DESC")
    List<Owner> findAllOwnersOrderByStatusDesc();

    Optional<Owner> findByUserId(long userId);

    //    List<PropertyOffers> findOffersByIdAndOffersPropertyId(long ownerId, long propertyId);
//    List<PropertyOffers> findByOffers_Property_IdAndId(long propertyId, long ownerId);

}
