package com.devmura.repository;

import com.devmura.entity.Heart;
import com.devmura.entity.Post;
import com.devmura.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeartRepository extends JpaRepository <Heart, Integer> {
    Optional<Heart> findByPostAndUser(Post post, User user);
}
