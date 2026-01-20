package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "customer_registration")
public class CustomerRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // primary key

    @Column(unique = true, nullable = false)
    private String mobile; // mobile number

    private String otp; // last generated otp

    @Column(nullable = false)
    private String status; // PENDING or VERIFIED

    private LocalDateTime createdAt; // when created
    private LocalDateTime updatedAt; // when updated
    private LocalDateTime verifiedAt; // when otp verified

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getVerifiedAt() {
        return verifiedAt;
    }

    public void setVerifiedAt(LocalDateTime verifiedAt) {
        this.verifiedAt = verifiedAt;
    }
}
