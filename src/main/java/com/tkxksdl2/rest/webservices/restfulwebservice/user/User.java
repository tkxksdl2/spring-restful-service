package com.tkxksdl2.rest.webservices.restfulwebservice.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tkxksdl2.rest.webservices.restfulwebservice.post.Post;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;


@Entity(name = "user_detail")
public class User {
    @Id @GeneratedValue
    private int id;
    @Size(min=2, max = 10, message = "name은 2자에서 10자 사이입니다.")
    private String name;
    @Past(message = "BirthDate는 과거 날짜여야 합니다.")
    private LocalDate birthDate;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Post> posts;

    public User() {
    }

    public User(int id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
