package com.example.demo.service;

import com.example.demo.models.Profile;
import com.example.demo.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private ProfileRepo repository;

    public Profile createProfile(Profile profileData) {
        Profile profile = new Profile();
        profile.setFirstName(profileData.getFirstName());
        profile.setLastName(profileData.getLastName());
        profile.setUsername(profileData.getUsername());
        profile.setPassword(passwordEncoder.encode(profileData.getPassword()));
        profile.setEmail(profileData.getEmail());
        profile.setChannelList(profileData.getChannelList());
        return repository.save(profile);
    }

    public Profile findById(Long id) {
        return repository.getById(id);
    }

    public List<Profile> findAllProfiles() {
        return repository.findAll();
    }

    public Profile login(String username, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        return repository.findByUsernameAndPassword(username, encodedPassword);
    }

    public Profile update(Profile profileData) {
        return repository.save(profileData);
    }

    public Profile deleteProfileById(Long id) {
        Profile profileToDelete = findById(id);
        repository.deleteById(id);
        return profileToDelete;
    }
}
