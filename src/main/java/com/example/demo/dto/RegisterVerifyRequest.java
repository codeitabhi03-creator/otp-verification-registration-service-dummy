package com.example.demo.dto;

public class RegisterVerifyRequest {
    private String mobile;   // mobile entered by user
    private String otp;      // otp entered by user

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
