package com.devmura.service.impl;

import com.devmura.dto.CommentDto;
import com.devmura.dto.UserDto;
import com.devmura.entity.Comment;
import com.devmura.entity.Post;
import com.devmura.entity.User;
import com.devmura.mapper.CommentMapper;
import com.devmura.mapper.UserMapper;
import com.devmura.repository.CommentRepository;
import com.devmura.repository.PostRepository;
import com.devmura.repository.UserRepository;
import com.devmura.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;


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

    @Override
    public ResponseEntity<Comment> saveComment(Comment comment, Integer postId, Integer userId) {
        try {
            Optional<User> userOptional = userRepository.findById(userId);
            Optional<Post> postOptional = postRepository.findById(postId);

            if (userOptional.isPresent() && postOptional.isPresent()) {
                User user = userOptional.get();
                Post post = postOptional.get();

                comment.setUser(user);
                comment.setPost(post);
                comment.setIsVisible(1);

                commentRepository.save(comment);

                return ResponseEntity.ok(comment);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(comment);
        }
    }

    @Override
    public ResponseEntity<Comment> deleteComment(Integer commentId, Integer userId) {
        Comment comment = commentRepository.findById(commentId).orElse(null);

        if (comment == null) {
            return ResponseEntity.notFound().build();
        }
        if (!comment.getUser().getId().equals(userId)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        comment.setIsVisible(0);

        Comment updatedComment = commentRepository.save(comment);
        return ResponseEntity.ok(updatedComment);
    }

    @Override
    public ResponseEntity<List<CommentDto>> getAllComments() {
        if (commentRepository.findAll().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            List<Comment> comments = commentRepository.findAll();
            List<CommentDto> commentDtos = comments
                    .stream()
                    .map(comment -> CommentMapper.mapToCommentDto(comment))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(commentDtos, HttpStatus.OK);
        }
    }



    @Override
    public ResponseEntity<List<CommentDto>> getAllCommentsActive() {
        List<Comment> comments = commentRepository.findByIsVisible(1);

        if (comments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            List<CommentDto> commentDtos = comments
                    .stream()
                    .map(comment -> CommentMapper.mapToCommentDto(comment))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(commentDtos, HttpStatus.OK);
        }
    }

    public ResponseEntity<List<CommentDto>> getAllCommentsActiveByPost(Integer postId) {
        List<Comment> comments = commentRepository.findByIsVisibleAndPostId(1, postId);

        if (comments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            List<CommentDto> commentDtos = comments
                    .stream()
                    .map(comment -> CommentMapper.mapToCommentDto(comment))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(commentDtos, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<Comment> update(Integer commentId, String newContent, Integer userId) {
        Optional<Comment> commentOptional = commentRepository.findById(commentId);

        if (commentOptional.isPresent()) {
            Comment comment = commentOptional.get();
            if (!comment.getUser().getId().equals(userId)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            comment.setContent(newContent);
            Comment updatedComment = commentRepository.save(comment);
            return ResponseEntity.ok(updatedComment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
