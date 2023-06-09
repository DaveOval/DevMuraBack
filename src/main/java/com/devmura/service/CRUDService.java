package com.devmura.service;

import com.devmura.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CRUDService <T> {
    ResponseEntity<List<?>> findAll();
    ResponseEntity<?> findById(Integer id);
    ResponseEntity<?> save(T t);
    ResponseEntity<?> delete(Integer id);
}
