package com.devmura.service.impl;

import com.devmura.entity.Auth;
import com.devmura.entity.Heart;
import com.devmura.entity.Post;
import com.devmura.entity.User;
import com.devmura.repository.HeartRepository;
import com.devmura.repository.PostRepository;
import com.devmura.repository.UserRepository;
import com.devmura.service.HeartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class HeartServiceImpl implements HeartService {

    @Autowired
    HeartRepository heartRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<List<?>> findAll() {
        if (heartRepository.findAll().isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(heartRepository.findAll());
        }
    }

    @Override
    public ResponseEntity<?> findById(Integer id) {
        Optional<Heart> heart = heartRepository.findById(id);
        if (heart.isPresent()) {
            return new ResponseEntity<>(heart, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Heart not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> save(Heart heart) {
        try {
            return ResponseEntity.ok(heartRepository.save(heart));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }




    @Override
    public ResponseEntity<?> delete(Integer id) {
        if (heartRepository.findById(id).isPresent()) {
            heartRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Heart> saveHeart(Heart heart, Integer postId, Integer userId) {
        try {
            Optional<Post> post = postRepository.findById(postId);
            Optional<User> user = userRepository.findById(userId);

            if (post.isPresent() && user.isPresent()) {
                Optional<Heart> existingHeart = heartRepository.findByPostAndUser(post.get(), user.get());

                if (existingHeart.isPresent()) {
                    Heart heartToUpdate = existingHeart.get();
                    heartToUpdate.setStatus(heartToUpdate.getStatus() == 0 ? 1 : 0);
                    heartRepository.save(heartToUpdate);
                    return ResponseEntity.ok(heartToUpdate);
                } else {
                    heart.setPost(post.get());
                    heart.setUser(user.get());
                    heart.setCreatedAt(LocalDateTime.now());
                    heart.setStatus(1);
                    return ResponseEntity.ok(heartRepository.save(heart));
                }
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(heart);
        }
    }




}
