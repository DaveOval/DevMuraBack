package com.devmura.controller;

import com.devmura.dto.CommentDto;
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
    public ResponseEntity<List<CommentDto>> getAll(){
        return commentService.getAllComments();
    }

    @GetMapping("/active")
    public ResponseEntity<List<CommentDto>> getAllActive(){
        return commentService.getAllCommentsActive();
    }


    @PutMapping("/delete")
    public ResponseEntity<Comment> deleteComment(@RequestParam Integer commentId, @RequestParam Integer userId) {
        return commentService.deleteComment(commentId, userId);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Comment comment, @RequestParam Integer postId, @RequestParam Integer userId) {
        return commentService.saveComment(comment, postId, userId);
    }

    @PutMapping("/update")
    public ResponseEntity<Comment> update(@RequestParam Integer commentId, @RequestBody String content, @RequestParam Integer userId) {
        return commentService.update(commentId, content, userId);
    }
}
