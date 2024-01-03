package com.tkxksdl2.rest.webservices.restfulwebservice.versioning;

import com.tkxksdl2.rest.webservices.restfulwebservice.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class VersioningUserController {

    @GetMapping("/v1/user")
    public User getFirstVersionOfUser(){
        return new User(1, "Kim", LocalDate.now());
    }

    @GetMapping("/v2/user")
    public User getSecondVersionOfUser(){
        return new UserV2(1, "Kim", "kun", LocalDate.now());
    }

    @GetMapping(value = "/versioning/users", params = "version=1")
    public User getFirstVersionOfUserByParam(){
        return new User(1, "Kim", LocalDate.now());
    }

    @GetMapping(value = "/versioning/users", params = "version=2")
    public User getSecondVersionOfUserByParam(){
        return new UserV2(1, "Kim", "kun", LocalDate.now());
    }

    @GetMapping(path = "/versioning/users/header", headers = "X-API-VERSION=1")
    public User getFirstVersionOfUserByRequestHeader(){
        return new User(1, "Kim", LocalDate.now());
    }

    @GetMapping(path = "/versioning/users/header", headers = "X-API-VERSION=2")
    public User getSecondVersionOfUserByRequestHeader(){
        return new UserV2(1, "Kim", "kun", LocalDate.now());
    }

    @GetMapping(path = "/versioning/users/accept", produces = "application/vnd.company.app-v1+json")
    public User getFirstVersionOfUserByAcceptHeader(){
        return new User(1, "Kim", LocalDate.now());
    }

    @GetMapping(path = "/versioning/users/accept", produces = "application/vnd.company.app-v2+json")
    public User getSecondVersionOfUserByAcceptHeader(){
        return new UserV2(1, "Kim", "kun", LocalDate.now());
    }
}
