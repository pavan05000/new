package com.pathbreaker.payslip.response;

import lombok.Data;

@Data
public class StatusResponse{
    private int status;

    private String statusInfo;
}
