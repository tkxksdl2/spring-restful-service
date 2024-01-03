package com.tkxksdl2.rest.webservices.restfulwebservice.versioning;

import com.tkxksdl2.rest.webservices.restfulwebservice.user.User;

import java.time.LocalDate;

public class UserV2 extends User {
    private String lastName;

    public UserV2(int id, String name, String lastName, LocalDate birthDate) {
        super(id, name, birthDate);
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }
}
