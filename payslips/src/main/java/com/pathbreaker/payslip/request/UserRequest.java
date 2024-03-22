package com.pathbreaker.payslip.request;

import com.pathbreaker.payslip.entity.UserLoginEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.Date;

@Data
public class UserRequest {

    private String userId;

    private String emailId;

    private String userName;

    private String password;

    private String role;

    private Date registrationDate;

    private UserLoginEntity userLoginEntity;
}
