package com.example.demo.dto;

public class RegisterInitResponse {
        private String status; // OTP_SENT or ALREADY_VERIFIED
        private String otp;    // dummy otp for now

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
