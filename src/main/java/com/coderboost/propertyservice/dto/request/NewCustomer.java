package com.coderboost.propertyservice.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewCustomer {
    private String email;
    private String password;
}
