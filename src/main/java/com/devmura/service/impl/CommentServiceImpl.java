package com.devmura.service.impl;

import com.devmura.entity.Comment;
import com.devmura.repository.CommentRepository;
import com.devmura.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void delete(Integer id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Optional<Comment> findCommentById(Integer id) {
        return commentRepository.findById(id);
    }

    @Override
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }
 
    
}
