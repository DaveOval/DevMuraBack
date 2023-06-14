package com.devmura.service;

import com.devmura.dto.PostDto;
import com.devmura.dto.UserDto;
import com.devmura.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PostService extends CRUDService<Post>{
    public ResponseEntity<List<PostDto>> getAllPosts();
    public ResponseEntity<List<PostDto>> getPaginatedPosts(int page, int size);
    public ResponseEntity<?> savePostById(Post post, Integer id);
}
