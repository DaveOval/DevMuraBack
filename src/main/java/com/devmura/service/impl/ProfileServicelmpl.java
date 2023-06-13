package com.devmura.service.impl;

import com.devmura.dto.ProfileDto;
import com.devmura.entity.Country;
import com.devmura.entity.Profile;
import com.devmura.entity.User;
import com.devmura.mapper.ProfileMapper;
import com.devmura.repository.CountryRepository;
import com.devmura.repository.ProfileRepository;
import com.devmura.repository.UserRepository;
import com.devmura.service.ProfileService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfileServicelmpl implements ProfileService {
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    CountryRepository countryRepository;

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
    public ResponseEntity<ProfileDto> getProfileDtoById(Integer id) {
        Optional<Profile> profile = profileRepository.findById(id);
        if (profile.isPresent()) {
            Profile loadedProfile = profile.get();
            loadedProfile.getLanguageProfiles();
            ProfileDto profileDto = ProfileMapper.mapToProfileDto(loadedProfile, userRepository);
            return ResponseEntity.ok(profileDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<?> updateProfile(Integer id, ProfileDto updatedProfileDto) {
        Optional<Profile> optionalProfile = profileRepository.findById(id);
        if (optionalProfile.isPresent()) {
            Profile profile = optionalProfile.get();

            profile.setBirthday(updatedProfileDto.getBirthday());
            profile.setBio(updatedProfileDto.getBio());
            profile.setImg(updatedProfileDto.getImg());
            profile.setGithub(updatedProfileDto.getGithub());
            profile.setLikedin(updatedProfileDto.getLikedin());
            profile.setBackground(updatedProfileDto.getBackground());
            profile.setRole(updatedProfileDto.getRole());

            User user = profile.getUser();
            user.setName(updatedProfileDto.getName());
            user.setLastName(updatedProfileDto.getLastName());
            Country country = countryRepository.findByCode(updatedProfileDto.getCountry());
            if (country != null) {
                user.setCountry(country);
            } else {
                return ResponseEntity.badRequest().body("Country not found");
            }


            Profile updatedProfile = profileRepository.save(profile);

            return ResponseEntity.ok(updatedProfile);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
