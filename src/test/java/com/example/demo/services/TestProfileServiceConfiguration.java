package com.example.demo.services;

import com.example.demo.service.ProfileService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class TestProfileServiceConfiguration {

    @Bean
    @Primary
    public ProfileService profileService() {
        return Mockito.mock(ProfileService.class);
    }
}
