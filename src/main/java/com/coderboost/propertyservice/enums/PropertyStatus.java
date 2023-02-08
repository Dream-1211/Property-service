package com.coderboost.propertyservice.enums;

public enum PropertyStatus {

    UNAVAILABLE,
    AVAILABLE,
    PENDING,
    CONTINGENT;

    public boolean isAvailable() {
        return this == AVAILABLE;
    }
}
