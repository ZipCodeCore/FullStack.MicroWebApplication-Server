package com.example.demo.service;

import com.example.demo.models.Profile;
import com.example.demo.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ProfileRepo repository;

    public Profile createProfile(Profile profileData) {
        Profile profile = new Profile();
        profile.setFirstName(profileData.getFirstName());
        profile.setLastName(profileData.getLastName());
        profile.setUsername(profileData.getUsername());
        profile.setPassword(passwordEncoder.encode(profileData.getPassword()));
        profile.setEmail(profileData.getEmail());
        profile.setChannels(profileData.getChannels());
        return repository.save(profile);
    }

    public Profile findById(Long id) {
        return repository.findById(id).get();
    }

    public List<Profile> findAllProfiles() {
        return repository.findAll();
    }

    public Profile login(String username, String password) {
        Profile profileToCheckPassword = repository.findByUsername(username);
        if (verifyPassword(password, profileToCheckPassword)) {
            return profileToCheckPassword;
        }
        return null;
    }

    public Profile update(Profile profileData) {
        return repository.save(profileData);
    }

    public void deleteProfileById(Long id) {
        repository.deleteById(id);
    }

    private boolean verifyPassword(String password, Profile profile) {
        return passwordEncoder.matches(password, profile.getPassword());
    }
}
