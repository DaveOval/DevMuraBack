package com.devmura.service;

import com.devmura.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    public void savePost(Post post);
    public void deletePost(Integer id);
    public Optional<Post> findPostById(Integer id);
    public List<Post> findAllPosts();
}
