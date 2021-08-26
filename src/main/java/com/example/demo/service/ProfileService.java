package com.example.demo.service;

import com.example.demo.models.Profile;
import com.example.demo.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ProfileRepo repository;

    public Profile createProfile(Profile profileData) {
        profileData.setPassword(passwordEncoder.encode(profileData.getPassword()));
        return repository.save(profileData);
    }

    public Profile findById(Long id) {
        return repository.findById(id).get();
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
