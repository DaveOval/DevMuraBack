package com.devmura.service.impl;

import com.devmura.entity.Post;
import com.devmura.repository.PostRepository;
import com.devmura.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public ResponseEntity<List<?>> findAll() {
        if (postRepository.findAll().isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(postRepository.findAll());
        }
    }

    @Override
    public ResponseEntity<?> findById(Integer id) {
        try {
            Optional<Post> post = postRepository.findById(id);
            if (post.isPresent()) {
                return ResponseEntity.ok(post);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> save(Post post) {
        try {
            postRepository.save(post);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(post);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        if (postRepository.findById(id).isPresent()) {
            postRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
