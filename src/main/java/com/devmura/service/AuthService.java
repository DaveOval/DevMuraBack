package com.devmura.service;

import com.devmura.entity.Auth;

import java.util.List;
import java.util.Optional;


public interface AuthService {
    public void save(Auth auth);
    public void delete(Integer id);
    public Optional<Auth> findCommentById(Integer id);
    List<Auth> getAll();
        
}
