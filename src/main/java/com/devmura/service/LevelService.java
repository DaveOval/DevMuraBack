package com.devmura.service;

import com.devmura.entity.Level;

import java.util.List;
import java.util.Optional;

public interface LevelService extends CRUDService<Level>{
    Optional<Level> findLevelById(Integer id);
}
