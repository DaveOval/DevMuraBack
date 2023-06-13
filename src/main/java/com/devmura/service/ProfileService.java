package com.devmura.service;

import com.devmura.dto.PostDto;
import com.devmura.dto.ProfileDto;
import com.devmura.entity.Friend;
import com.devmura.entity.Profile;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProfileService extends CRUDService<Profile>{
    public ResponseEntity<List<ProfileDto>> getAllProfiles();
    public ResponseEntity<ProfileDto> getProfileDtoById(Integer id);
    public ResponseEntity<?> updateProfile(Integer id, ProfileDto profileDto);
}
