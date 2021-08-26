package com.example.demo.controller;

import com.example.demo.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/profile")
public class ProfileController {

    @Autowired
    ProfileService service;
}
