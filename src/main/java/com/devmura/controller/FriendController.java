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

    public ResponseEntity<List<Friend>> getFriends(){
        List<Friend> friends = friendService.findAll();
        return  ResponseEntity.ok(friends);
    }

    



    @PostMapping

    public ResponseEntity<Void> saveFriend(@RequestBody Friend friend){
        friendService.save(friend);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        friendService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
