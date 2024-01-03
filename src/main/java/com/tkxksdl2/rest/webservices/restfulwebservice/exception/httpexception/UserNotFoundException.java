package com.tkxksdl2.rest.webservices.restfulwebservice.exception.httpexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends HttpException {
    public UserNotFoundException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
        this.setName("UserNotFound");
    }
}
