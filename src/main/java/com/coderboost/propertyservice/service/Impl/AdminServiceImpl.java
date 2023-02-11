package com.coderboost.propertyservice.service.Impl;

import com.coderboost.propertyservice.dto.response.AdminStatisticsDto;
import com.coderboost.propertyservice.repo.CustomerRepo;
import com.coderboost.propertyservice.repo.OwnerRepo;
import com.coderboost.propertyservice.repo.PropertyOfferRepo;
import com.coderboost.propertyservice.repo.PropertyRepo;
import com.coderboost.propertyservice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {


    private final OwnerRepo ownerRepo;
    private final PropertyRepo propertyRepo;
    private final PropertyOfferRepo offerRepo;
    private final CustomerRepo customerRepo;

    @Autowired
    public AdminServiceImpl(OwnerRepo ownerRepo, PropertyRepo propertyRepo, PropertyOfferRepo offerRepo, CustomerRepo customerRepo) {
        this.ownerRepo = ownerRepo;
        this.propertyRepo = propertyRepo;
        this.offerRepo = offerRepo;
        this.customerRepo = customerRepo;
    }

    @Override
    public AdminStatisticsDto getCustomerOwnerAndPropertyStatistics() {

        AdminStatisticsDto dashboard = AdminStatisticsDto.builder()
                .owners(ownerRepo.count())
                .properties(propertyRepo.count())
                .customers(customerRepo.count())
                .offers(offerRepo.count())
                .build();
        return dashboard;
    }
}
