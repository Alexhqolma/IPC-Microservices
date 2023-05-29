package com.ipc.userservice.service;

import com.ipc.userservice.model.UserInsurance;

public interface UserInsuranceService {
    UserInsurance countInsurance(Long userId, UserInsurance userInsurance);
}
