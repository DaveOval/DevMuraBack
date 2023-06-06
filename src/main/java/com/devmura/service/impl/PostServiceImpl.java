package com.devmura.service.impl;

import com.devmura.entity.Post;
import com.devmura.repository.PostRepository;
import com.devmura.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public void savePost(Post post) {
        postRepository.save(post);
    }

    @Override
    public void deletePost(Integer id) {
        postRepository.deleteById(id);
    }

    @Override
    public Optional<Post> findPostById(Integer id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }
}
