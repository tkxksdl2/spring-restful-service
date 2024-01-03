package com.tkxksdl2.rest.webservices.restfulwebservice.exception;

import com.tkxksdl2.rest.webservices.restfulwebservice.exception.errordetail.BasicErrorDetails;
import com.tkxksdl2.rest.webservices.restfulwebservice.exception.errordetail.HttpErrorDetails;
import com.tkxksdl2.rest.webservices.restfulwebservice.exception.errordetail.FieldErrorDetails;
import com.tkxksdl2.rest.webservices.restfulwebservice.exception.httpexception.HttpException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<BasicErrorDetails> handleAllException(Exception ex, WebRequest request) throws Exception {
        BasicErrorDetails errorDetails = new BasicErrorDetails(
                LocalDateTime.now(), request.getDescription(false));
        return new ResponseEntity<BasicErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpException.class)
    public final ResponseEntity<HttpErrorDetails> handleUserNotFoundException(HttpException ex, WebRequest request) throws Exception {
        HttpErrorDetails errorDetails = new HttpErrorDetails(
                LocalDateTime.now(), request.getDescription(false), ex);
        return new ResponseEntity<HttpErrorDetails>(errorDetails, ex.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        FieldErrorDetails errorDetails = new FieldErrorDetails(
                LocalDateTime.now(), request.getDescription(false), ex.getFieldErrors());

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

}
