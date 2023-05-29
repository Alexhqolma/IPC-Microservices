package com.ipc.userservice.dto.mapper;

import com.ipc.userservice.dto.request.UserInsuranceRequestDto;
import com.ipc.userservice.dto.response.UserInsuranceResponseDto;
import com.ipc.userservice.model.UserInsurance;
import org.springframework.stereotype.Component;

@Component
public class UserInsuranceMapper {
    public UserInsurance toModel(UserInsuranceRequestDto dto) {
        UserInsurance userInsurance = new UserInsurance();
        userInsurance.setAnnualMileage(dto.getAnnualMileage());
        userInsurance.setPostalCode(dto.getPostalCode());
        userInsurance.setVehicleManufacturer(dto.getVehicleManufacturer());
        userInsurance.setCountResult(dto.getCountResult());
        userInsurance.setUserId(dto.getUserId());
        return userInsurance;
    }

    public UserInsuranceResponseDto toDto(UserInsurance userInsurance) {
        UserInsuranceResponseDto dto = new UserInsuranceResponseDto();
        dto.setAnnualMileage(userInsurance.getAnnualMileage());
        dto.setPostalCode(userInsurance.getPostalCode());
        dto.setVehicleManufacturer(userInsurance.getVehicleManufacturer());
        dto.setCountResult(userInsurance.getCountResult());
        dto.setUserId(userInsurance.getUserId());
        return dto;
    }
}
