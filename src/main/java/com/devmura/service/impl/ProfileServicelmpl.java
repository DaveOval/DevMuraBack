package com.devmura.service.impl;

import com.devmura.entity.Profile;
import com.devmura.repository.ProfileRepository;
import com.devmura.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServicelmpl implements ProfileService {
    @Autowired
    ProfileRepository profileRepository;

    @Override
    public void save(Profile profile) {
        profileRepository.save(profile);

    }

    @Override
    public void delete(Integer id) {
        profileRepository.deleteById(id);
    }

    @Override
    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Override
    public Optional<Profile> findProfileById(Integer id) {
        return profileRepository.findById(id);
    }

    @Override
    public List<Profile> getAll() {
        return profileRepository.findAll();
    }
}
