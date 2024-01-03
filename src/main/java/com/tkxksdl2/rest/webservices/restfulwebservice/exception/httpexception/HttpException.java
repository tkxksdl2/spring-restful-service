package com.tkxksdl2.rest.webservices.restfulwebservice.exception.httpexception;

import org.springframework.http.HttpStatus;

public class HttpException extends RuntimeException {
    private HttpStatus httpStatus;
    private String errorName;

    public HttpException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
        this.errorName = "Http Exception";
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getName() {
        return errorName;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public void setName(String errorName) {
        this.errorName = errorName;
    }
}
