package com.devmura.service;

import com.devmura.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService extends CRUDService<User> {
    // public Page<User> findAll(Pageable pageable);
    public ResponseEntity<List<?>> findByNameLike(String pattern);

    public ResponseEntity<List<?>> findByName(String name);

    public boolean existsByEmail(String email);

    public boolean existsByUsername(String username);
}
