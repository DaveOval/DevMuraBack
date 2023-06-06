package com.devmura.service.impl;

import com.devmura.entity.Group;
import com.devmura.repository.GroupRepository;
import com.devmura.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupRepository groupRepository;

    @Override
    public void saveGroup(Group group) {
        groupRepository.save(group);
    }

    @Override
    public void deleteGroup(Integer id) {
        groupRepository.deleteById(id);
    }

    @Override
    public Optional<Group> findGroupById(Integer id) {
        return groupRepository.findById(id);
    }

    @Override
    public List<Group> findAllGroups() {
        return groupRepository.findAll();
    }
}
