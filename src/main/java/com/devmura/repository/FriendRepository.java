package com.devmura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devmura.entity.Friend;

public interface FriendRepository extends JpaRepository<Friend,Integer>  {
    
}
