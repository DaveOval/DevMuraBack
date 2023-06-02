package com.devmura.repository;

import com.devmura.entity.Level;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles
class LevelRepositoryTest {
    @Autowired
    LevelRepository levelRepository;

    @Test
    public void findAll(){
        List<Level> levels = levelRepository.findAll();
        if(!levels.isEmpty()){
            levels.forEach(System.out::println);
        }
        else{
            System.out.println("no data");
        }
    }
    @Test
    public void saveLevel(){
        try{
            Level level = new Level();
            level.setName("VIP");
            levelRepository.save(level);
            System.out.println(level);
            assertNotNull(level.getId());
        }catch( Exception err ){
            System.out.println( err );
        }
    }
    @Test
    public void findByid(){
        Level level = levelRepository.findById(1).get();
        assertEquals(1, level.getId());
    }
}