package com.devmura.controller;

import com.devmura.entity.Comment;
import com.devmura.repository.CommentRepository;
import com.devmura.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = "*")
public class CommentController {
    @Autowired
    CommentService commentService;

    //http://localhost:8080/api/comment/all
    @GetMapping
    public ResponseEntity<List<?>> getAll(){
        return commentService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Comment comment) {
        return commentService.save(comment);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return commentService.delete(id);
    }
}
