package com.devmura.controller;

import com.devmura.entity.Post;
import com.devmura.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@CrossOrigin(origins = "*")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/all")
    public ResponseEntity<List<Post>> getAllPosts(){
        List<Post> posts = postService.findAllPosts();
        return ResponseEntity.ok(posts);
    }
    @PostMapping("/save")
    public ResponseEntity<Void> savePost(@RequestBody Post post){
        postService.savePost(post);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") Integer id){
        Post post = postService.findPostById(id).get();
        return ResponseEntity.ok(post);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable("id") Integer id){
        postService.deletePost(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
