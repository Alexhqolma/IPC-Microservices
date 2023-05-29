package com.ipc.userservice.dto.request;

import com.ipc.userservice.model.VehicleManufacturer;
import java.math.BigDecimal;
import lombok.Getter;

@Getter
public class UserInsuranceRequestDto {
    private int annualMileage;
    private int postalCode;
    private VehicleManufacturer vehicleManufacturer;
    private BigDecimal countResult;
    private Long userId;
}
