package com.devmura.controller;

import com.devmura.entity.Group;
import com.devmura.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@CrossOrigin(origins = "*")
public class GroupController {

    @Autowired
    GroupService groupService;

    @GetMapping
    public ResponseEntity<List<?>> getGroups(){
        return groupService.findAll();
    }
    @PostMapping
    public ResponseEntity<?> saveGroup(@RequestBody Group group) {
        return groupService.save(group);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable Integer id) {
        return groupService.delete(id);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getGroupById(@PathVariable Integer id) {
        return groupService.findById(id);
    }
}
