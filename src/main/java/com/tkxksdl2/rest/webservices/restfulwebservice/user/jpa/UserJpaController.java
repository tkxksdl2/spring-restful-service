package com.tkxksdl2.rest.webservices.restfulwebservice.user.jpa;

import com.tkxksdl2.rest.webservices.restfulwebservice.exception.httpexception.UserNotFoundException;
import com.tkxksdl2.rest.webservices.restfulwebservice.user.User;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaController {
    private final UserRepository userRepository;

    public UserJpaController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> findOneById(@PathVariable int id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) throw new UserNotFoundException("id: " + id, HttpStatus.NOT_FOUND);

        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User newUser =  userRepository.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();

        return ResponseEntity.created(location).build();
//        return ResponseEntity.created(null).body(newUser);
    }

    @DeleteMapping("/jpa/users/{id}")
    public void DeleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }

}
