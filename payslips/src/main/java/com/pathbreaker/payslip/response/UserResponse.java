package com.pathbreaker.payslip.response;

import com.pathbreaker.payslip.entity.UserLoginEntity;
import lombok.Data;

import java.util.Date;

@Data
public class UserResponse {

    private String userId;

    private String emailId;

    private String userName;

    private String password;

    private String role;

    private Date registrationDate;

    private UserLoginResponse userLoginResponse;
}
