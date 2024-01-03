package com.tkxksdl2.rest.webservices.restfulwebservice.post;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tkxksdl2.rest.webservices.restfulwebservice.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
public class Post {
    @Id @GeneratedValue
    private int id;
    @Size(min = 2, max = 500)
    private String description;
    @ManyToOne( fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public Post() {
    }

    public Post(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", user=" + user.getName() +
                '}';
    }
}
