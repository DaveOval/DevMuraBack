package com.devmura.service;

import com.devmura.entity.Friend;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface FriendService extends CRUDService<Friend>{
    public ResponseEntity<Friend> sendFriendRequest(Integer userId, Integer friendId);
    public ResponseEntity<Friend> acceptFriendRequest(Integer friendId);
}
