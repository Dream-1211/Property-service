package com.coderboost.propertyservice.enums;

public enum PropertyStatus {
    AVAILABLE,
    PENDING,
    CONTINGENT;

    public boolean isAvailable() {
        return this == AVAILABLE;
    }
}
