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

    @GetMapping
    public ResponseEntity<List<?>> getAllPosts(){
        return postService.findAll();
    }
    @PostMapping
    public ResponseEntity<?> savePost(@RequestBody Post post){
        return postService.save(post);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getPostById(@PathVariable("id") Integer id){
        return postService.findById(id);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePost(@PathVariable("id") Integer id){
        return postService.delete(id);
    }

}
