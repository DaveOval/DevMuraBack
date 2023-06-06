package com.devmura.repository;

import com.devmura.entity.Heart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeartRepository extends JpaRepository <Heart, Integer> {
}
