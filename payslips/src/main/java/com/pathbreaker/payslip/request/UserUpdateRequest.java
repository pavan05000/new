package com.pathbreaker.payslip.request;

import com.pathbreaker.payslip.entity.UserLoginEntity;
import lombok.Data;

import java.util.Date;

@Data
public class UserUpdateRequest {

    private String emailId;

    private String userName;

    private String password;

    private String role;

    private Date registrationDate;

    private UserLoginUpdateRequest userLoginUpdateRequest;
}
