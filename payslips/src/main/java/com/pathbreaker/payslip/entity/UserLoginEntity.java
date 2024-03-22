package com.pathbreaker.payslip.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "UserLogin")
public class UserLoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String emailId;

    private String userName;

    private String password;

    private String role;

    private Long otp;

    private Date lastLoginTime;

    private LocalDateTime expiryTime;


    @OneToOne
    @JoinColumn(name = "userId")
    private UserEntity userEntity;
}
