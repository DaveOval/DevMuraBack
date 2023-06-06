package com.devmura.controller;

import com.devmura.entity.Profile;
import com.devmura.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profile")
@CrossOrigin(origins = "*")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping("/all")
    public ResponseEntity<List<Profile>> getProfiles(){
        List<Profile> profiles = profileService.findAll();
        return ResponseEntity.ok(profiles);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveProfile(@RequestBody Profile profile){
        profileService.save(profile);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        profileService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
