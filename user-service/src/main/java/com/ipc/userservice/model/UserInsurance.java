package com.ipc.userservice.model;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class UserInsurance {
    private int annualMileage;
    private int postalCode;
    private VehicleManufacturer vehicleManufacturer;
    private BigDecimal countResult;
    private Long userId;
}
