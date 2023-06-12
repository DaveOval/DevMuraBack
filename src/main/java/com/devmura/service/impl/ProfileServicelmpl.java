package com.devmura.service.impl;

import com.devmura.dto.PostDto;
import com.devmura.dto.ProfileDto;
import com.devmura.entity.Profile;
import com.devmura.mapper.PostMapper;
import com.devmura.mapper.ProfileMapper;
import com.devmura.repository.ProfileRepository;
import com.devmura.repository.UserRepository;
import com.devmura.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfileServicelmpl implements ProfileService {
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<List<?>> findAll() {
        if (profileRepository.findAll().isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(profileRepository.findAll());
        }
    }

    @Override
    public ResponseEntity<?> findById(Integer id) {
        if (profileRepository.findById(id).isPresent()) {
            return ResponseEntity.ok(profileRepository.findById(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<?> save(Profile profile) {
        return ResponseEntity.ok(profileRepository.save(profile));
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        if (profileRepository.findById(id).isPresent()) {
            profileRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<ProfileDto>> getAllProfiles() {
        List<Profile> profiles = profileRepository.findAll();

        if (profiles.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<ProfileDto> profileDtoList = profiles.stream()
                    .map(profile -> ProfileMapper.mapToProfileDto(profile, userRepository))
                    .collect(Collectors.toList());

        return ResponseEntity.ok(profileDtoList);
    }

    @Override
    public ResponseEntity<?> updateProfile(Integer id, ProfileDto profileDto) {
        Profile profile = profileRepository.findById(id).orElse(null);
        if (profile == null) {
            return ResponseEntity.notFound().build();
        }
        profileRepository.save(profile);
        return ResponseEntity.ok().build();
    }
}
