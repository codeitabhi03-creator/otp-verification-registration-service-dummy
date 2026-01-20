package com.example.demo.repository;

import com.example.demo.model.CustomerRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRegistrationRepository extends JpaRepository<CustomerRegistration, Long> {
    Optional<CustomerRegistration> findByMobile(String mobile); // fetch by mobile
}