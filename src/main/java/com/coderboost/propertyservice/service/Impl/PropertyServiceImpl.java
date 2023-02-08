package com.coderboost.propertyservice.service.Impl;

import com.coderboost.propertyservice.dto.request.PropertyCreateDto;
import com.coderboost.propertyservice.dto.response.PropertyDetailsDto;
import com.coderboost.propertyservice.entity.Owner;
import com.coderboost.propertyservice.entity.Property;
import com.coderboost.propertyservice.enums.PropertyStatus;
import com.coderboost.propertyservice.repo.OwnerRepo;
import com.coderboost.propertyservice.repo.PropertyRepo;
import com.coderboost.propertyservice.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.coderboost.propertyservice.mapper.PropertyMapper.toPropertyDetailDto;
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

    @Override
    public void updatePropertyStatus(long propertyId, PropertyStatus propertyStatus) {
        Property property = propertyRepo.findById(propertyId).orElseThrow(() -> new RuntimeException("Property doesn't exist"));
        property.setStatus(propertyStatus);
        propertyRepo.save(property);
    }

    @Override
    public List<PropertyDetailsDto> fetchProperties() {
        List<Property> properties = propertyRepo.findAll();
        return toPropertyDetailDto(properties);
    }

    @Override
    public void deleteProperty(long propertyId) {
        Property property = propertyRepo.findById(propertyId).orElseThrow(() -> new RuntimeException("Property doesn't exist"));
        property.setActive(false);
        propertyRepo.save(property);
    }
}
