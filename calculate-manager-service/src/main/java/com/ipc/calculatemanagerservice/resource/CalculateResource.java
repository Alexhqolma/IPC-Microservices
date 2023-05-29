package com.ipc.calculatemanagerservice.resource;

import com.ipc.calculatemanagerservice.model.UserInsurance;
import com.ipc.calculatemanagerservice.service.CalculateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
@AllArgsConstructor
public class CalculateResource {
    private final CalculateService calculateService;

    @PostMapping("/{userId}")
    public UserInsurance getCalculateInfo(@PathVariable Long userId,
                                          @RequestBody UserInsurance userInsurance) {
        return calculateService.getCalculateInsurance(userId, userInsurance);
    }
}
