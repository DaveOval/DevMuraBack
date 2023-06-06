package com.devmura.service.impl;

import com.devmura.entity.Friend;
import com.devmura.repository.FriendRepository;
import com.devmura.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FriendServicelmpl implements FriendService {
    @Autowired
    FriendRepository friendRepository;

    @Override
    public void save(Friend friend) {
        friendRepository.save(friend);
    }

    @Override
    public void delete(Integer id) {
        friendRepository.deleteById(id);
    }

    @Override
    public Optional<Friend> findFriendById(Integer id) {
        return friendRepository.findById(id);
    }

    @Override
    public List<Friend> getAll() {
        return friendRepository.findAll();
    }
}
