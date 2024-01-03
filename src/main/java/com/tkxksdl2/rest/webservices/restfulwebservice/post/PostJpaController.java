package com.tkxksdl2.rest.webservices.restfulwebservice.post;

import com.tkxksdl2.rest.webservices.restfulwebservice.exception.httpexception.PostNotFoundException;
import com.tkxksdl2.rest.webservices.restfulwebservice.exception.httpexception.PostUserNotMatchException;
import com.tkxksdl2.rest.webservices.restfulwebservice.exception.httpexception.UserNotFoundException;
import com.tkxksdl2.rest.webservices.restfulwebservice.user.User;
import com.tkxksdl2.rest.webservices.restfulwebservice.user.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
public class PostJpaController {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostJpaController(PostRepository postRepository,UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable int id){
        User user = this.userRepository.findById(id).orElse(null);
        if (user == null) throw new UserNotFoundException("id: " + id, HttpStatus.NOT_FOUND);

        return user.getPosts();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Post> createPostForUser(
            @PathVariable int id,
            @Valid @RequestBody Post post){
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) throw new UserNotFoundException("id: " + id, HttpStatus.NOT_FOUND);

        post.setUser(user.get());
        Post newPost =  postRepository.save(post);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(newPost.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/jpa/users/{userId}/posts/{postId}")
    public Post retrievePostByPostIdAndUserId(
            @PathVariable int userId,
            @PathVariable int postId
    ) {
        Optional<Post> post = postRepository.findById(postId);
        if(post.isEmpty()) throw new PostNotFoundException("id :"+ postId, HttpStatus.NOT_FOUND);

        if(post.get().getUser().getId() != userId)
            throw new PostUserNotMatchException("user_id :" + userId +" NOT Match", HttpStatus.BAD_REQUEST);

        return post.get();
    }


}
