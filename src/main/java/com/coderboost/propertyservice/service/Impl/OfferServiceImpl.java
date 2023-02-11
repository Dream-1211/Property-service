package com.coderboost.propertyservice.service.Impl;

import com.coderboost.propertyservice.dto.request.OfferCreateDto;
import com.coderboost.propertyservice.entity.Customer;
import com.coderboost.propertyservice.entity.Owner;
import com.coderboost.propertyservice.entity.Property;
import com.coderboost.propertyservice.entity.PropertyOffer;
import com.coderboost.propertyservice.enums.OfferStatus;
import com.coderboost.propertyservice.repo.CustomerRepo;
import com.coderboost.propertyservice.repo.OwnerRepo;
import com.coderboost.propertyservice.repo.PropertyOfferRepo;
import com.coderboost.propertyservice.repo.PropertyRepo;
import com.coderboost.propertyservice.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

import static com.coderboost.propertyservice.mapper.PropertyOfferMapper.toPropertyOffersEntityBuilder;

@Service
public class OfferServiceImpl implements OfferService {

    private final PropertyOfferRepo offerRepo;
    private final PropertyRepo propertyRepo;
    private final OwnerRepo ownerRepo;
    private final CustomerRepo customerRepo;

    @Autowired
    public OfferServiceImpl(PropertyOfferRepo offerRepo, PropertyRepo propertyRepo, OwnerRepo ownerRepo, CustomerRepo customerRepo) {
        this.offerRepo = offerRepo;
        this.propertyRepo = propertyRepo;
        this.ownerRepo = ownerRepo;
        this.customerRepo = customerRepo;
    }


    @Override
    public void addNewOffer(OfferCreateDto offerCreateDto) {
        Property property = propertyRepo.findById(offerCreateDto.getPropertyId()).orElseThrow(() -> new RuntimeException("Property doesn't exist"));
        Owner owner = ownerRepo.findById(offerCreateDto.getOwnerId()).orElseThrow(() -> new RuntimeException("Owner doesn't exist"));
        Customer customer = customerRepo.findByUserId(offerCreateDto.getCustomerId()).orElseThrow(() -> new RuntimeException("Customer doesn't exist"));

        PropertyOffer newOffer = toPropertyOffersEntityBuilder(offerCreateDto)
                .property(property)
                .owner(owner)
                .customer(customer)
                .build();

        offerRepo.save(newOffer);
    }

    @Override
    public void updateOfferStatus(long offerId, OfferStatus offerStatus) {
        PropertyOffer offer = offerRepo.findById(offerId).orElseThrow(() -> new RuntimeException("Offer doesn't exist"));
        offer.setStatus(offerStatus);
        offer.setUpdatedAt(Instant.now());
        offerRepo.save(offer);
    }
}
