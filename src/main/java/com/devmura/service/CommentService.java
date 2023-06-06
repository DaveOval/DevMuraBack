package com.devmura.service;

import com.devmura.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    public void save(Comment comment);
    public void delete(Integer id);
    public Optional<Comment> findCommentById(Integer id);
    List<Comment> getAll();
    
}
