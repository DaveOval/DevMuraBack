package com.devmura.controller;

import com.devmura.entity.Friend;
import com.devmura.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/friend")
@CrossOrigin(origins = "*")
public class FriendController {

    @Autowired
    FriendService friendService;

    @GetMapping
    public ResponseEntity<List<?>> getFriends(){
        return friendService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> saveFriend(@RequestBody Friend friend){
        return friendService.save(friend);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        return friendService.delete(id);
    }


}
