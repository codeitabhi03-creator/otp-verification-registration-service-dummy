package com.example.demo.service;

import com.example.demo.dto.RegisterInitResponse;
import com.example.demo.dto.RegisterVerifyResponse;
import com.example.demo.model.CustomerRegistration;
import com.example.demo.repository.CustomerRegistrationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class RegistrationService {
    private final CustomerRegistrationRepository repo;

    public RegistrationService(CustomerRegistrationRepository repo) {
        this.repo = repo;
    }

    public RegisterInitResponse initRegistration(String mobile) {

        Optional<CustomerRegistration> existing = repo.findByMobile(mobile); // fetch by mobile

        if (existing.isPresent() && existing.get().getStatus().equals("VERIFIED")) {
            RegisterInitResponse res = new RegisterInitResponse();
            res.setStatus("ALREADY_VERIFIED");
            res.setOtp(null);
            return res; // user already verified
        }

        String otp = String.format("%06d", new Random().nextInt(999999)); // generate 6-digit otp

        CustomerRegistration record = existing.orElseGet(CustomerRegistration::new); // new or existing
        record.setMobile(mobile); // set mobile
        record.setOtp(otp); // set new otp
        record.setStatus("PENDING"); // pending verification
        record.setCreatedAt(record.getCreatedAt() == null ? LocalDateTime.now() : record.getCreatedAt()); // set created only once
        record.setUpdatedAt(LocalDateTime.now()); // always update update time

        repo.save(record); // save to DB

        RegisterInitResponse res = new RegisterInitResponse();
        res.setStatus("OTP_SENT"); // frontend can move to OTP screen
        res.setOtp(otp); // currently return otp for dev testing

        return res;
    }

    public RegisterVerifyResponse verifyOtp(String mobile, String otp) {

        Optional<CustomerRegistration> existing = repo.findByMobile(mobile); // fetch record by mobile
        RegisterVerifyResponse res = new RegisterVerifyResponse();           // response object

        if (existing.isEmpty()) {
            res.setStatus("NOT_FOUND"); // no registration started
            return res;
        }

        CustomerRegistration record = existing.get(); // get record

        if (!record.getOtp().equals(otp)) {
            res.setStatus("INVALID_OTP"); // wrong otp
            return res;
        }

        // correct otp
        record.setStatus("VERIFIED");             // mark verified
        record.setVerifiedAt(LocalDateTime.now()); // timestamp
        record.setUpdatedAt(LocalDateTime.now());  // update timestamp
        repo.save(record);                         // save changes

        res.setStatus("VERIFIED");
        return res;
    }

}
