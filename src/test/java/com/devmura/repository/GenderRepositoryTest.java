package com.devmura.repository;

import com.devmura.entity.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("devmura")
class GenderRepositoryTest {
    @Autowired
    GenderRepository genderRepository;

    @Test
    public void getAll() {
        Iterable<Gender> genders = genderRepository.findAll();
        genders.forEach(System.out::println);
    }



}