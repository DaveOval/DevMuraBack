package com.devmura.service.impl;

import com.devmura.entity.Comment;
import com.devmura.entity.User;
import com.devmura.repository.CommentRepository;
import com.devmura.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;


    @Override
    public ResponseEntity<List<?>> findAll() {
        if (commentRepository.findAll().isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(commentRepository.findAll());
        }
    }

    @Override
    public ResponseEntity<?> findById(Integer id) {
        Optional<Comment> comment = commentRepository.findById(id);
        if (comment.isPresent()) {
            return new ResponseEntity<>(comment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Comment not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> save(Comment comment) {
        try {
            commentRepository.save(comment);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(comment);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        if (commentRepository.findById(id).isPresent()) {
            commentRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
