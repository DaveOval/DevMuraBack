package com.devmura.service.impl;

import com.devmura.dto.PostDto;
import com.devmura.dto.UserDto;
import com.devmura.entity.Post;
import com.devmura.entity.Profile;
import com.devmura.entity.User;
import com.devmura.mapper.PostMapper;
import com.devmura.mapper.ProfileMapper;
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
import java.util.Collections;
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
        return null;
    }

    @Override
    public ResponseEntity<?> savePostById(Post post, Integer id) {
        try {
            Optional<User> user = userRepository.findById(id);
            if (user == null) {
                throw new IllegalArgumentException("User not found");
            }
            post.setUser(user.get());
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
    public ResponseEntity<List<PostDto>> getPaginatedPosts(int page, int size) {
        try {
            Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
            Page<Post> postPage = postRepository.findAll(pageable);
            List<PostDto> postDtos = postPage.getContent().stream()
                    .map(post -> {
                        PostDto postDto = PostMapper.mapToPostDto(post, userRepository);
                        int heartsCount = post.getHearts().size();
                        postDto.setCounter(heartsCount + "");
                        return postDto;
                    })
                    .collect(Collectors.toList());

            return ResponseEntity.ok(postDtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
