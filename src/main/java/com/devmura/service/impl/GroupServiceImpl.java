package com.devmura.service.impl;

import com.devmura.dto.GroupDto;
import com.devmura.entity.*;
import com.devmura.mapper.GroupMapper;
import com.devmura.repository.GroupRepository;
import com.devmura.repository.PostRepository;
import com.devmura.repository.UserRepository;
import com.devmura.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;



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
    public ResponseEntity<?> saveGroupById(Group group, Integer id) {
        try {
            Optional<User> userOptional = userRepository.findById(id);
            if (!userOptional.isPresent()) {
                throw new IllegalArgumentException("User not found");
            }
            User user = userOptional.get();
            group.setUser(user);
            groupRepository.save(group);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return new ResponseEntity<>("Group saved", HttpStatus.CREATED);
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

    @Override
    public ResponseEntity<?> addPostToGroup(Integer groupId, Post post, Integer userId) {
        try {
            Optional<Group> groupOptional = groupRepository.findById(groupId);

            if (groupOptional.isEmpty()) {
                throw new IllegalArgumentException("Group not found");
            }

            Optional<User> userOptional = userRepository.findById(userId);

            if (userOptional.isEmpty()) {
                throw new IllegalArgumentException("User not found");
            }

            User user = userOptional.get();
            post.setUser(user);
            postRepository.save(post);

            Group group = groupOptional.get();
            group.addPost(post);

            groupRepository.save(group);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return new ResponseEntity<>("Post added to Group", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<GroupDto>> getAllGroups() {
        if (groupRepository.findAll().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            List<Group> groups = groupRepository.findAll();
            List<GroupDto> groupDtos = groups
                    .stream()
                    .map(group -> GroupMapper.mapToGroupDto(group, userRepository))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(groupDtos, HttpStatus.OK);
        }
    }


}
