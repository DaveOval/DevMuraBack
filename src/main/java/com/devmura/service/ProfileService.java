package com.devmura.service;

import com.devmura.entity.Friend;
import com.devmura.entity.Profile;

import java.util.List;
import java.util.Optional;

public interface ProfileService {
    void save(Profile profile);
    void delete(Integer id);
    List<Profile> findAll();
    Optional<Profile> findProfileById(Integer id);
    List<Profile> getAll();
}
