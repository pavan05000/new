package com.pathbreaker.payslip.repository;

import com.pathbreaker.payslip.entity.EmployeeLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeLoginRepository extends JpaRepository<EmployeeLoginEntity, Integer> {
    EmployeeLoginEntity findByEmailId(String emailId);

    EmployeeLoginEntity findByOtp(Long otp);
}
