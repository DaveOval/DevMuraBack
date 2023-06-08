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
@RequestMapping("/api/comment")
@CrossOrigin(origins = "*")
public class CommentController {
    @Autowired
    CommentService commentService;

    //http://localhost:8080/api/comment/all
    @GetMapping
    public ResponseEntity<List<Comment>> getAll(){
        List<Comment> comments = commentService.getAll();
        return ResponseEntity.ok(comments);
    } 

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Comment comment) {
        commentService.save(comment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        commentService.delete(id);
        return ResponseEntity.ok().build();
    }
}
