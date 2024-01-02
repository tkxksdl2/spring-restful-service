package com.tkxksdl2.rest.webservices.restfulwebservice.exception.errordetail;

import java.time.LocalDateTime;

public class ErrorDetails extends BasicErrorDetails {
    private String message;

    public ErrorDetails(LocalDateTime timeStamps, String details, String message) {
        super(timeStamps, details);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
