package com.coderboost.propertyservice.service.Impl;

import com.coderboost.propertyservice.dto.response.OwnerDetailsDto;
import com.coderboost.propertyservice.dto.response.OwnerDto;
import com.coderboost.propertyservice.entity.Owner;
import com.coderboost.propertyservice.enums.UserStatus;
import com.coderboost.propertyservice.mapper.OwnerMapper;
import com.coderboost.propertyservice.repo.OwnerRepo;
import com.coderboost.propertyservice.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepo ownerRepo;

    @Autowired
    public OwnerServiceImpl(OwnerRepo ownerRepo) {
        this.ownerRepo = ownerRepo;
    }

    @Override
    public List<OwnerDto> getAllOwners() {
        List<Owner> ownerList = ownerRepo.findAllOwnersOrderByStatusDesc();
        return OwnerMapper.toListDto(ownerList);
    }

    @Override
    public OwnerDetailsDto getOwnerDetailsById(long id) {
        Optional<Owner> owner = ownerRepo.findById(id);
        OwnerDetailsDto ownerDetils = new OwnerDetailsDto();
        if (owner.isPresent()) {
            ownerDetils = OwnerMapper.toOwnerDetailsDto(owner.get());
        }
        return ownerDetils;
    }

    @Override
    public void updateOwnerStatus(long id, UserStatus status) {

        Optional<Owner> owner = ownerRepo.findById(id);
        if (owner.isPresent()) {
            owner.get().setStatus(status);
            ownerRepo.save(owner.get());
        } else throw new RuntimeException("Owner with ID " + id + " does not exist");
    }
}
