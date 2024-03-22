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
@Table(name = "EmployeeLogin")
public class EmployeeLoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 6)
    private Long otp;

    private String emailId;

    private String password;

    private int status;

    @Column(columnDefinition = "TIMESTAMP")
    private Date lastLoginTime;

    private String role;

    private String ipAddress;

    private LocalDateTime expiryTime;

    @OneToOne
    @JoinColumn(name = "employeeId")
    private EmployeeEntity employeeEntity;

}
