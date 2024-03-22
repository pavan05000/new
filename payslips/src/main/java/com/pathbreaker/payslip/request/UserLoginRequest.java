package com.pathbreaker.payslip.request;

import com.pathbreaker.payslip.entity.UserEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class UserLoginRequest {

    private String emailId;

    private String userName;

    private String password;

    private String otp;

    private String role;

    private Date lastLoginTime;

    private UserEntity userEntity;

    private LocalDateTime expiryTime;
}
