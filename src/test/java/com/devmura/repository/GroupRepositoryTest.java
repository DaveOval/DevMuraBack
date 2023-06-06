package com.devmura.repository;

import com.devmura.entity.Group;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("devmura")
public class GroupRepositoryTest {

    @Autowired
    GroupRepository groupRepository;

    @Test
    public void findAllGroups() {
        List<Group> groups = groupRepository.findAll();
        if (!groups.isEmpty()) {
            groups.forEach(System.out::println);
        } else {
            System.out.println("No data");
        }
    }

    @Test
    public void saveGroup() {
        try {
            Group group = new Group();
            group.setTitle("Sample Group");
            group.setDescription("This is a sample group");
            groupRepository.save(group);
            System.out.println(group);
            assertNotNull(group.getId());
        } catch (Exception err) {
            System.out.println(err);
        }
    }

    @Test
    public void findGroupById() {
        Group group = groupRepository.findById(1).orElse(null);
        assertNotNull(group);
        assertEquals(1, group.getId());
    }
}
