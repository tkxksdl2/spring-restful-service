package com.tkxksdl2.rest.webservices.restfulwebservice.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<User>();
    private static int counter = 5;

    static {
        users.add(new User(1, "tkxksdl2", LocalDate.now().minusYears(2)));
        users.add(new User(2, "vodka", LocalDate.now().minusYears(2)));
        users.add(new User(3, "balder", LocalDate.now().minusYears(2)));
        users.add(new User(4, "voiser", LocalDate.now().minusYears(2)));
    }

    public List<User> findAll(){
        return users;
    }

    public User findOne(int id){
        return users.stream().filter((user) -> user.getId() == id)
                .findFirst().orElse(null);
    }

    public User save(User user){
        user.setId(counter++);
        users.add(user);
        return user;
    }

    public void deleteById(int id){
        users.removeIf((user) -> user.getId() == id);
    }

}
