package com.coderboost.propertyservice.enums;

public enum UserStatus {
    ACTIVE,
    INACTIVE,
    DELETED;

    public boolean isActive() {
        return this == ACTIVE;
    }
}

