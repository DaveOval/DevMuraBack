package com.devmura.repository;

import com.devmura.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Integer> {
    List<Profile> findByUserName(String name);
}
