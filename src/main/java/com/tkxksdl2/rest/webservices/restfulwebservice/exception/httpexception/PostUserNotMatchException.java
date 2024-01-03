package com.tkxksdl2.rest.webservices.restfulwebservice.exception.httpexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class PostUserNotMatchException extends HttpException {
    public PostUserNotMatchException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
        this.setName("PostUserNotMatch");
    }
}
