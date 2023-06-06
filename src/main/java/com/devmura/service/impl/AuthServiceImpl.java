package com.devmura.service.impl;

import com.devmura.entity.Auth;
import com.devmura.repository.AuthRepository;
import com.devmura.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    AuthRepository authRepository;

    @Override
    public void save(Auth auth) {
        authRepository.save(auth);
    }

    @Override
    public void delete(Integer id) {
        authRepository.deleteById(id);
    }

    @Override
    public Optional<Auth> findCommentById(Integer id) {
        return authRepository.findById(id);
    }

    @Override
    public List<Auth> getAll() {
        return authRepository.findAll();
    }
    
}
