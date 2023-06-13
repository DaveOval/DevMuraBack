package com.devmura.service.impl;

import com.devmura.dto.PostDto;
import com.devmura.dto.UserDto;
import com.devmura.entity.Post;
import com.devmura.entity.Profile;
import com.devmura.entity.User;
import com.devmura.mapper.PostMapper;
import com.devmura.mapper.UserMapper;
import com.devmura.repository.PostRepository;
import com.devmura.repository.UserRepository;
import com.devmura.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

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
        return new ResponseEntity<>("Post saved", HttpStatus.CREATED);
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

    @Override
    public ResponseEntity<List<PostDto>> getAllPosts() {
        List<Post> posts = postRepository.findAll();

        if (posts.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<PostDto> postDtoList = posts.stream()
                .map(post -> PostMapper.mapToPostDto(post, userRepository))
                .collect(Collectors.toList());

        return ResponseEntity.ok(postDtoList);
    }

    @Override
    public ResponseEntity<List<PostDto>> findAll(Pageable pageable) {
        Page<Post> posts = postRepository.findAll(pageable);

        if (posts.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<PostDto> postDtoList = posts.stream()
                .map(post -> PostMapper.mapToPostDto(post, userRepository))
                .collect(Collectors.toList());

        return ResponseEntity.ok(postDtoList);
    }


}
