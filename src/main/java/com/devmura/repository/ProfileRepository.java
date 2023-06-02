package com.devmura.repository;

import com.devmura.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile,Integer> {
    List<Profile> findByUserName(String name);
}
