package com.pathbreaker.payslip.repository;

import com.pathbreaker.payslip.entity.UserLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLoginEntity, Long> {
    UserLoginEntity findByEmailIdOrUserName(String emailId, String userName);

    UserLoginEntity findByOtp(String otp);
}
