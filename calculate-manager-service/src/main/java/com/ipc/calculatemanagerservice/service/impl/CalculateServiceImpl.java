package com.ipc.calculatemanagerservice.service.impl;

import com.ipc.calculatemanagerservice.model.CompanyInfo;
import com.ipc.calculatemanagerservice.model.UserInsurance;
import com.ipc.calculatemanagerservice.model.VehicleManufacturer;
import com.ipc.calculatemanagerservice.repository.UserInsuranceRepository;
import com.ipc.calculatemanagerservice.service.CalculateService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CalculateServiceImpl implements CalculateService {
    @Value("${fileResourceUrl.url}")
    private String fileResourceUrl;
    private final UserInsuranceRepository userInsuranceRepository;
    private final RestTemplate restTemplate;

    public CalculateServiceImpl(UserInsuranceRepository userInsuranceRepository,
                                RestTemplate restTemplate) {
        this.userInsuranceRepository = userInsuranceRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public UserInsurance getCalculateInsurance(Long userId, UserInsurance userInsurance) {
        CompanyInfo companyInfo = restTemplate.getForObject(fileResourceUrl, CompanyInfo.class);
        int postIndex = (companyInfo != null) ? companyInfo.getPostIndexes().get(0) : 0;
        BigDecimal annualMileageFactor = getAnnualMileageFactor(userInsurance.getAnnualMileage());
        BigDecimal typeClassFactor = getTypeClassFactor(userInsurance.getVehicleManufacturer());
        BigDecimal regionalClassFactor = getRegionalClassFactor(postIndex);
        BigDecimal annualPremium
                = (annualMileageFactor.multiply(typeClassFactor)).multiply(regionalClassFactor);
        userInsurance.setCountResult(annualPremium);
        userInsurance.setUserId(userId);
        userInsuranceRepository.save(userInsurance);
        return userInsurance;
    }

    private BigDecimal getAnnualMileageFactor(int annualMileage) {
        if (annualMileage <= 5000) {
            return BigDecimal.valueOf(0.5);
        } else if (annualMileage <= 10000) {
            return BigDecimal.valueOf(1.0);
        } else if (annualMileage <= 20000) {
            return BigDecimal.valueOf(1.5);
        } else {
            return BigDecimal.valueOf(2.0);
        }
    }

    private BigDecimal getTypeClassFactor(VehicleManufacturer typeClassFactor) {
        if (typeClassFactor.toString().equals("BMW")) {
            return BigDecimal.valueOf(0.5);
        } else if (typeClassFactor.toString().equals("MERCEDES")) {
            return BigDecimal.valueOf(1.0);
        } else if (typeClassFactor.toString().equals("AUDI")) {
            return BigDecimal.valueOf(1.5);
        } else {
            return BigDecimal.valueOf(2.0);
        }
    }

    private BigDecimal getRegionalClassFactor(int index) {
        if (index == 10001) {
            return BigDecimal.valueOf(0.5);
        } else if (index == 10002) {
            return BigDecimal.valueOf(1.0);
        } else if (index == 20001) {
            return BigDecimal.valueOf(1.5);
        } else if (index == 20002) {
            return BigDecimal.valueOf(2.0);
        } else {
            return BigDecimal.valueOf(2.5);
        }
    }
}
