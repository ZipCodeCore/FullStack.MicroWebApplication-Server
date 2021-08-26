package com.example.demo.service;

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
}
