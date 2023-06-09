package com.devmura.service.impl;

import com.devmura.entity.Auth;
import com.devmura.entity.Friend;
import com.devmura.entity.User;
import com.devmura.repository.FriendRepository;
import com.devmura.repository.UserRepository;
import com.devmura.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FriendServicelmpl implements FriendService {

    @Autowired
    FriendRepository friendRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<List<?>> findAll() {
        if (friendRepository.findAll().isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(friendRepository.findAll());
        }
    }

    @Override
    public ResponseEntity<?> findById(Integer id) {
        Optional<Friend> friend = friendRepository.findById(id);
        if (friend.isPresent()) {
            return new ResponseEntity<>(friend, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Friend not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> save(Friend friend) {
        try {
            friendRepository.save(friend);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(friend);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        if (friendRepository.findById(id).isPresent()) {
            friendRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Friend> sendFriendRequest(Integer userId, Integer friendId) {
        try {
            Optional<User> user = userRepository.findById(userId);
            Optional<User> friendUser = userRepository.findById(friendId);

            if (user.isPresent() && friendUser.isPresent()) {
                Optional<Friend> existingFriend = friendRepository.findByUserAndFriendUser(user.get(), friendUser.get());

                if (existingFriend.isPresent()) {
                    Friend friend = existingFriend.get();
                    int isActivated = friend.getIsActivated();

                    if (isActivated == 1) {
                        friend.setIsActivated(0);
                    } else {
                        friend.setIsActivated(1);
                    }

                    return ResponseEntity.ok(friendRepository.save(friend));
                } else {
                    Friend friendRequest = new Friend();
                    friendRequest.setUser(user.get());
                    friendRequest.setFriendUser(friendUser.get());
                    friendRequest.setAccepted(0);
                    friendRequest.setIsActivated(1);

                    Friend savedFriend = friendRepository.save(friendRequest);
                    return ResponseEntity.ok(savedFriend);
                }
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }



    @Override
    public ResponseEntity<Friend> acceptFriendRequest(Integer friendId) {
        try {
            Optional<Friend> friend = friendRepository.findById(friendId);
            if (friend.isPresent()) {
                Friend friendRequest = friend.get();
                friendRequest.setAccepted(1);
                friendRepository.save(friendRequest);
                return ResponseEntity.ok(friendRequest);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<List<Friend>> getFriendRequestsByUser(Integer userId) {
        try {
            Optional<User> user = userRepository.findById(userId);
            if (user.isPresent()) {
                List<Friend> friendRequests = friendRepository.findByUser(user.get());
                return ResponseEntity.ok(friendRequests);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
