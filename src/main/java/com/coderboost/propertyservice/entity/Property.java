package com.coderboost.propertyservice.entity;


import com.coderboost.propertyservice.enums.PropertyCategory;
import com.coderboost.propertyservice.enums.PropertyStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "property")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    PropertyLocation location;
    String detail;
    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    PropertyCategory category;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    PropertyStatus status = PropertyStatus.UNAVAILABLE;
    boolean isActive = false;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    Owner owner;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    @JoinColumn(name = "property_id")
    List<PropertyImage> images;
}
