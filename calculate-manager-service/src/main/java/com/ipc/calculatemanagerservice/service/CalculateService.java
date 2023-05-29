package com.ipc.calculatemanagerservice.service;

import com.ipc.calculatemanagerservice.model.UserInsurance;

public interface CalculateService {
    UserInsurance getCalculateInsurance(Long userId, UserInsurance userInsurance);
}
