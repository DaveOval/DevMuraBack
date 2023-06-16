package com.devmura.service;

import com.devmura.dto.CommentDto;
import com.devmura.entity.Comment;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CommentService extends CRUDService<Comment>{
    public ResponseEntity<Comment> saveComment(Comment comment, Integer postId, Integer userId);
    public ResponseEntity<Comment> deleteComment(Integer commentId, Integer userId);
    public ResponseEntity<List<CommentDto>> getAllComments();
    public ResponseEntity<List<CommentDto>> getAllCommentsActive();
    public ResponseEntity<List<CommentDto>> getAllCommentsActiveByPost(Integer postId);
    public ResponseEntity<Comment> update(Integer commentId, String newContent, Integer userId);
}
