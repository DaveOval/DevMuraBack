package com.devmura.repository;

import com.devmura.entity.Group;
import com.devmura.repository.GroupRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class GroupRepositoryTest {
    @Autowired
    GroupRepository groupRepository;

    @Test
    public void testFindAll(){
        List<Group> groups = groupRepository.findAll();
        groups.forEach(System.out::println);
    }

    @Test
    public void findById(){
        Integer id = 1;
        Group group = groupRepository.findById(id).orElse(null);
        System.out.println(group);
        assertNotNull(group);
        assertEquals(id, group.getId());
    }
}
