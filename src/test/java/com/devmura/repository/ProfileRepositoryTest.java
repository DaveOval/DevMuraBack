package com.devmura.repository;

import com.devmura.entity.Level;
import com.devmura.entity.Profile;
import com.devmura.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.text.DateFormat;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("devmura")
class ProfileRepositoryTest {

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    LevelRepository levelRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    public void saveprofile(){
        Profile profile = new Profile();
        profile.setBirthday(new Date());
        profile.setBio("Fullstack Developer");
        profile.setImg("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinterest.com");
        profile.setGithub("github.com/devmura");
        profile.setLikedin("linkedin.com/in/devmura");
        profile.setBackground("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinterest.com");

        Optional<Level> levelTest = levelRepository.findById(1);
        if (levelTest.isPresent()){
            profile.setLevel(levelTest.get());
        } else {
            System.out.println("Level not found");
        }

        Optional<User> userTest = userRepository.findById(1);
        if (userTest.isPresent()){
            profile.setUser(userTest.get());
        } else {
            System.out.println("User not found");
        }

        profileRepository.save(profile);

    }

    @Test
    void findByUserNameTest(){
        System.out.println("find by name of user test");
        profileRepository.findByUserName("Pablito").forEach(System.out::println);
    }
}