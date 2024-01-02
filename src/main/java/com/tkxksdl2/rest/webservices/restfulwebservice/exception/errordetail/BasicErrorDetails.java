package com.tkxksdl2.rest.webservices.restfulwebservice.exception.errordetail;

import java.time.LocalDateTime;

public class BasicErrorDetails {
    private LocalDateTime timeStamps;
    private String details;

    public BasicErrorDetails(LocalDateTime timeStamps, String details) {
        this.timeStamps = timeStamps;
        this.details = details;
    }

    public LocalDateTime getTimeStamps() {
        return timeStamps;
    }

    public String getDetails() {
        return details;
    }
}
