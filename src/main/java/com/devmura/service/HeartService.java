package com.devmura.service;

import com.devmura.entity.Heart;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface HeartService extends CRUDService<Heart>{
    public ResponseEntity<Heart> saveHeart(Heart heart, Integer postId, Integer userId);
}
