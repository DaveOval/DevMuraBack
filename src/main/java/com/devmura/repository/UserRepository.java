package com.devmura.repository;

import com.devmura.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByNameLike(String pattern);
    List<User> getByName(String name);
}
