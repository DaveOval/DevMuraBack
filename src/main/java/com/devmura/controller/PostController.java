package com.devmura.controller;

import com.devmura.dto.PostDto;
import com.devmura.entity.Post;
import com.devmura.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "*")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/all")
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

    @GetMapping("/dto")
    public ResponseEntity<List<PostDto>> getAllPostsDto(){
        return postService.getAllPosts();
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getPaginatedPosts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return postService.getPaginatedPosts(page, size);
    }

}
