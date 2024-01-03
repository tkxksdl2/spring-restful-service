package com.tkxksdl2.rest.webservices.restfulwebservice.user.jpa;

import com.tkxksdl2.rest.webservices.restfulwebservice.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
