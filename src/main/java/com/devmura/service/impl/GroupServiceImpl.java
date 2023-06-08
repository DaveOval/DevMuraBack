package com.devmura.service.impl;

import com.devmura.entity.Auth;
import com.devmura.entity.Group;
import com.devmura.repository.GroupRepository;
import com.devmura.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupRepository groupRepository;

    @Override
    public ResponseEntity<List<?>> findAll() {
        if (groupRepository.findAll().isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(groupRepository.findAll());
        }
    }

    @Override
    public ResponseEntity<?> findById(Integer id) {
        Optional<Group> group = groupRepository.findById(id);
        if (group.isPresent()) {
            return new ResponseEntity<>(group, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Group not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> save(Group group) {
        try {
            groupRepository.save(group);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(group);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        if (groupRepository.findById(id).isPresent()) {
            groupRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
