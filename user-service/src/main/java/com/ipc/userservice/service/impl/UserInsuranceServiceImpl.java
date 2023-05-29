package com.ipc.userservice.service.impl;

import com.ipc.userservice.model.UserInsurance;
import com.ipc.userservice.service.UserInsuranceService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserInsuranceServiceImpl implements UserInsuranceService {
    @Value("${calculate.url}")
    private String calculateUrl;
    private final RestTemplate restTemplate;

    public UserInsuranceServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public UserInsurance countInsurance(Long userId, UserInsurance userInsurance) {
        HttpEntity<UserInsurance> request = new HttpEntity<>(userInsurance);
        userInsurance = restTemplate
                .postForObject(calculateUrl + userId, request, UserInsurance.class);
        return userInsurance;
    }
}
