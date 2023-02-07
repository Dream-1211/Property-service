package com.coderboost.propertyservice.service.Impl;

import com.coderboost.propertyservice.dto.response.OwnerDto;
import com.coderboost.propertyservice.entity.Owner;
import com.coderboost.propertyservice.mapper.OwnerMapper;
import com.coderboost.propertyservice.repo.OwnerRepo;
import com.coderboost.propertyservice.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepo ownerRepo;

    @Autowired
    public OwnerServiceImpl(OwnerRepo ownerRepo) {
        this.ownerRepo = ownerRepo;
    }

    @Override
    public List<OwnerDto> getAllOwners() {
        List<Owner> ownerList = ownerRepo.findAll();
        return OwnerMapper.toListDto(ownerList);
    }
}
