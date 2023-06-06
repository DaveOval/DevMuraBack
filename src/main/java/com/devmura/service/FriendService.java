package com.devmura.service;

import com.devmura.entity.Friend;

import java.util.List;
import java.util.Optional;

public interface FriendService {
    void save(Friend friend);
    void delete(Integer id);
    List<Friend> findAll();
    Optional<Friend> findFriendById(Integer id);
    List<Friend> getAll();
}
