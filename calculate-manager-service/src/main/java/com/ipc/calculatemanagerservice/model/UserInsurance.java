package com.ipc.calculatemanagerservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserInsurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int annualMileage;
    private int postalCode;
    @Enumerated(EnumType.STRING)
    private VehicleManufacturer vehicleManufacturer;
    private BigDecimal countResult;
    private Long userId;
}
