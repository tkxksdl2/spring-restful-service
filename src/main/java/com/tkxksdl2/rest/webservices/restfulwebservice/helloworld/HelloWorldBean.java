package com.tkxksdl2.rest.webservices.restfulwebservice.helloworld;


public class HelloWorldBean {
    private String message;
    public HelloWorldBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message + " from Spring REST API!!";
    }
}
