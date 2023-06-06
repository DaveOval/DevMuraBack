package com.devmura.service;

import com.devmura.entity.Level;

import java.util.List;
import java.util.Optional;

public interface LevelService {
    public void save(Level level);
    public void delete(Integer id);
    public Optional<Level> findLevelById(Integer id);
    List<Level> getAll();
}
