package com.coderboost.propertyservice.service.Impl;

import com.coderboost.propertyservice.dto.request.PropertyCreateDto;
import com.coderboost.propertyservice.entity.Owner;
import com.coderboost.propertyservice.entity.Property;
import com.coderboost.propertyservice.repo.OwnerRepo;
import com.coderboost.propertyservice.repo.PropertyRepo;
import com.coderboost.propertyservice.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.coderboost.propertyservice.mapper.PropertyMapper.toPropertyEntityBuilder;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepo propertyRepo;
    private final OwnerRepo ownerRepo;


    @Autowired
    public PropertyServiceImpl(PropertyRepo propertyRepo, OwnerRepo ownerRepo) {
        this.propertyRepo = propertyRepo;
        this.ownerRepo = ownerRepo;
    }

    @Override
    public void addProperty(PropertyCreateDto propertyCreateDto) {
        Owner owner = ownerRepo.findById(propertyCreateDto.getOwnerId())
                .orElseThrow(() -> new RuntimeException("Owner not found"));
        Property newProperty = toPropertyEntityBuilder(propertyCreateDto).owner(owner).build();
        propertyRepo.save(newProperty);
    }
}
