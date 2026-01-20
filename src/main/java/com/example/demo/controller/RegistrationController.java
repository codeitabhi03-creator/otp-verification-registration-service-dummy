package com.example.demo.controller;

import com.example.demo.dto.RegisterVerifyRequest;
import com.example.demo.dto.RegisterVerifyResponse;
import com.example.demo.service.RegistrationService;
import com.example.demo.dto.RegisterInitRequest;
import com.example.demo.dto.RegisterInitResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/init")
    public RegisterInitResponse init(@RequestBody RegisterInitRequest request) {
        return registrationService.initRegistration(request.getMobile());
    }

    @PostMapping("/verify")
    public RegisterVerifyResponse verify(@RequestBody RegisterVerifyRequest request) {
        return registrationService.verifyOtp(request.getMobile(), request.getOtp());
    }

}
