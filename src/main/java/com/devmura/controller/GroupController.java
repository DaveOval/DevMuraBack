package com.devmura.controller;

import com.devmura.entity.Group;
import com.devmura.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group")
@CrossOrigin(origins = "*")
public class GroupController {

    @Autowired
    GroupService groupService;

    @GetMapping("/all")
    public ResponseEntity<List<Group>> getGroups(){
        List<Group> groups = groupService.findAllGroups();
        return ResponseEntity.ok(groups);
    }
    @PostMapping("/save")
    public ResponseEntity<Void> saveGroup(@RequestBody Group group) {
        groupService.saveGroup(group);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable Integer id) {
        groupService.deleteGroup(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable Integer id) {
        Group group = groupService.findGroupById(id).get();
        return ResponseEntity.ok(group);
    }
}
