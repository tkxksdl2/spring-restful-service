package com.tkxksdl2.rest.webservices.restfulwebservice.exception.errordetail;

import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FieldErrorDetails extends BasicErrorDetails {
    private Map<String, String> fieldMessages;

    public FieldErrorDetails(LocalDateTime timeStamps, String details
            , List<FieldError> fieldErrors) {
        super(timeStamps, details);

        this.fieldMessages = new HashMap<String,String>();
        fieldErrors.forEach((fieldError -> {
            this.fieldMessages.put(fieldError.getField(), fieldError.getDefaultMessage());
        }));
    }

    public Map<String, String> getFieldMessages() {
        return fieldMessages;
    }
}
