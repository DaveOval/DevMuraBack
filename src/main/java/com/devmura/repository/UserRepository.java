package com.devmura.repository;

import com.devmura.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByNameLike(String pattern);
    List<User> getByName(String name);
    boolean existsByEmailIgnoringCase(String email);
    boolean existsByUsernameIgnoringCase(String username);
    public User findByUsername(String username);
    public User findByEmail(String email);
}
