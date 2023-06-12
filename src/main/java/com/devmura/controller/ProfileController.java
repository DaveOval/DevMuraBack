package com.devmura.controller;

import com.devmura.dto.ProfileDto;
import com.devmura.entity.Profile;
import com.devmura.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
@CrossOrigin(origins = "*")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping
    public ResponseEntity<List<?>> getProfiles(){
        return profileService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> saveProfile(@RequestBody Profile profile){
        return profileService.save(profile);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        return profileService.delete(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProfileById(@PathVariable Integer id){
        return profileService.findById(id);
    }

    @GetMapping("/dto")
    public ResponseEntity<List<ProfileDto>> getAllProfilesDto(){
        return profileService.getAllProfiles();
    }
}
