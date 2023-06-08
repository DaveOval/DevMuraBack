package com.devmura.service.impl;

import com.devmura.entity.User;
import com.devmura.repository.UserRepository;
import com.devmura.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findById(Integer id) {
        Optional<User> op = userRepository.findById(id);
        return op.orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findByNameLike(String pattern) {
        return userRepository.findByNameLike(pattern);
    }

    @Override
    public List<User> findByName(String name) {
        return userRepository.getByName(name);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmailIgnoringCase(email);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsernameIgnoringCase(username);
    }


}
