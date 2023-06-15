package com.devmura.repository;

import com.devmura.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devmura.entity.Friend;

import java.util.List;
import java.util.Optional;

public interface FriendRepository extends JpaRepository<Friend,Integer>  {
    public List<Friend> findByFriendUserName(String name);
    public Optional<Friend> findByUserAndFriendUser(User user, User friendUser);
    public List<Friend> findByUser(User user);
}
