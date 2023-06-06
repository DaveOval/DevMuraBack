package com.devmura.service;

import com.devmura.entity.Group;

import java.util.List;
import java.util.Optional;

public interface GroupService {
    public void saveGroup(Group group);
    public void deleteGroup(Integer id);
    public Optional<Group> findGroupById(Integer id);
    public List<Group> findAllGroups();
}
