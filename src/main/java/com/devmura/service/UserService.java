package com.devmura.service;

import com.devmura.dto.UserDto;
import com.devmura.entity.User;
import com.devmura.entity.UserRole;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface UserService extends CRUDService<User> {
    // public Page<User> findAll(Pageable pageable);
    public ResponseEntity<List<?>> findByNameLike(String pattern);

    public ResponseEntity<List<?>> findByName(String name);

    public boolean existsByEmail(String email);

    public boolean existsByUsername(String username);
    public ResponseEntity<List<UserDto>> getAllUsers();
    public ResponseEntity<?> saveUser(User user);

    public ResponseEntity<UserDto> getUserById(Integer id);
}
