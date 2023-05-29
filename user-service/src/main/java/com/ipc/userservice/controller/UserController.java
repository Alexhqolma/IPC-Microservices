package com.ipc.userservice.controller;

import com.ipc.userservice.dto.mapper.UserInsuranceMapper;
import com.ipc.userservice.dto.request.UserInsuranceRequestDto;
import com.ipc.userservice.dto.response.UserInsuranceResponseDto;
import com.ipc.userservice.service.UserInsuranceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insurance")
@AllArgsConstructor
public class UserController {
    private final UserInsuranceService userInsuranceService;
    private final UserInsuranceMapper userInsuranceMapper;

    @PostMapping("/count/{userId}")
    public UserInsuranceResponseDto countInsurance(@PathVariable Long userId,
            @RequestBody UserInsuranceRequestDto userInsuranceRequestDto) {
        return userInsuranceMapper.toDto(userInsuranceService
                .countInsurance(userId, userInsuranceMapper.toModel(userInsuranceRequestDto)));
    }
}
