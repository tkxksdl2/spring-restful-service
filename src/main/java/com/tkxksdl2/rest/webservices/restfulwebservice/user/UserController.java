package com.tkxksdl2.rest.webservices.restfulwebservice.user;


import com.tkxksdl2.rest.webservices.restfulwebservice.exception.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    private final UserDaoService userService;

    public UserController(UserDaoService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    public List<User> retrieveAllUsers(){
        return userService.findAll();
    }

    @GetMapping("users/{id}")
    public User findOneById(@PathVariable int id) {
        User user = userService.findOne(id);
        if (user == null) throw new UserNotFoundException("id: " + id);

        return user;
    }

    @PostMapping("users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User newUser =  userService.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();

        return ResponseEntity.created(location).build();
//        return ResponseEntity.created(null).body(newUser);
    }

    @DeleteMapping("users/{id}")
    public void DeleteUser(@PathVariable int id) {
        userService.deleteById(id);
    }

}
