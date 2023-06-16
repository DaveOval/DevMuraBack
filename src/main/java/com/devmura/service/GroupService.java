package com.devmura.service;

import com.devmura.dto.GroupDto;
import com.devmura.entity.Group;
import com.devmura.entity.Post;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface GroupService extends CRUDService<Group>{
    public ResponseEntity<?> saveGroupById(Group group, Integer id);
    public ResponseEntity<?> addPostToGroup(Integer groupId, Post post, Integer userId);

    public ResponseEntity<List<GroupDto>> getAllGroups();
}
