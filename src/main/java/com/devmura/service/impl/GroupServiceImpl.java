package com.devmura.service.impl;

import com.devmura.entity.Group;
import com.devmura.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupService groupService;

    @Override
    public void saveGroup(Group group) {
        groupService.saveGroup(group);
    }

    @Override
    public void deleteGroup(Integer id) {
        groupService.deleteGroup(id);
    }

    @Override
    public Optional<Group> findGroupById(Integer id) {
        return groupService.findGroupById(id);
    }

    @Override
    public List<Group> findAllGroups() {
        return groupService.findAllGroups();
    }
}
