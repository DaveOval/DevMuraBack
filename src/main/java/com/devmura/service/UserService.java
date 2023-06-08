package com.devmura.service;

import com.devmura.entity.User;

import java.util.List;

public interface UserService {
    // public Page<User> findAll(Pageable pageable);
    public User findById(Integer id);
    public void save(User user);
    public void delete(Integer id);
    public List<User> findAll();
    public List<User> findByNameLike(String pattern);

    public List<User> findByName(String name);

    public boolean existsByEmail(String email);

    public boolean existsByUsername(String username);
}
