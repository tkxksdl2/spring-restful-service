package com.tkxksdl2.rest.webservices.restfulwebservice.exception.errordetail;

import com.tkxksdl2.rest.webservices.restfulwebservice.exception.httpexception.HttpException;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class HttpErrorDetails extends BasicErrorDetails {
    private String errorName;
    private String message;
    private HttpStatus httpStatus;

    public HttpErrorDetails(LocalDateTime timeStamps, String details, HttpException ex) {
        super(timeStamps, details);
        this.errorName = ex.getName();
        this.message = ex.getMessage();
        this.httpStatus = ex.getHttpStatus();
    }

    public String getMessage() {
        return message;
    }

    public String getErrorName() {
        return errorName;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
