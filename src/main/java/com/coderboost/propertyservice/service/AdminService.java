package com.coderboost.propertyservice.service;

import com.coderboost.propertyservice.dto.response.AdminStatisticsDto;

public interface AdminService {


    AdminStatisticsDto getCustomerOwnerAndPropertyStatistics();
}
