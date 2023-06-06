package com.devmura.service;

import com.devmura.entity.Heart;

import java.util.List;
import java.util.Optional;

public interface HeartService {
    public void save(Heart heart);
    public void delete(Integer id);
    public Optional<Heart> findById(Integer id);
    public List<Heart> getAll();

}
