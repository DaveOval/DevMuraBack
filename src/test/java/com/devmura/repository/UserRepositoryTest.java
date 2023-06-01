package com.devmura.repository;

import com.devmura.entity.Auth;
import com.devmura.entity.Gender;
import com.devmura.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("devmura")
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Autowired
    GenderRepository genderRepository;

    @Autowired
    AuthRepository authRepository;

    @Test
    public void saveUser() {
        User userTest = new User();
        userTest.setName("Juanito");
        userTest.setLastName("Banana");
        userTest.setAge(28);
        userTest.setEmail("juanito@correo.com");
        userTest.setUsername("juanitobanana3000");
        userTest.setCreatedAt(new Date());
        userTest.setPassword("bananas");

        Optional<Auth> authTest = authRepository.findById(1);

        if (authTest.isPresent()) {
            Auth auth = authTest.get();
            userTest.setAuth(auth);
        }

        Optional<Gender> genderTest = genderRepository.findById(1);

        if (genderTest.isPresent()) {
            Gender gender = genderTest.get();
            userTest.setGender(gender);
        }

        userRepository.save(userTest);
    }

    @Test
    public void getAll() {
        Iterable<User> users = userRepository.findAll();
        users.forEach(System.out::println);
    }

    @Test
    public void findByNameLike() {
        System.out.println("find users with 'j' as first character");
        List<User> users = userRepository.findByNameLike("j%");
        users.forEach(System.out::println);

        System.out.println("find users with name containing 'Juan'");
        List<User> users2 = userRepository.findByNameLike("%Juan%");
        users2.forEach(System.out::println);
    }
}