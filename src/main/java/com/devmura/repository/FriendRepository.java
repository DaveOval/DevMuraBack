package com.devmura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devmura.entity.Friend;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friend,Integer>  {
    public List<Friend> findByFriendUserName(String name);
}
