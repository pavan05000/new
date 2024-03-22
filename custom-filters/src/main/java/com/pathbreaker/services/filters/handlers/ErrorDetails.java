package com.pathbreaker.services.filters.handlers;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorDetails {

    private String message;
    private Date timeStamp;
    private String path;
    private String status;

}
