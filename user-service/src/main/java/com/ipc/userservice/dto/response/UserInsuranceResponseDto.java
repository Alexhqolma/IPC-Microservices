package com.ipc.userservice.dto.response;

import com.ipc.userservice.model.VehicleManufacturer;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class UserInsuranceResponseDto {
    private int annualMileage;
    private int postalCode;
    private VehicleManufacturer vehicleManufacturer;
    private BigDecimal countResult;
    private Long userId;
}
