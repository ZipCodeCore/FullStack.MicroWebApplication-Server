package com.example.demo.services;

import com.example.demo.DemoApplication;
import com.example.demo.models.Channel;
import com.example.demo.models.Profile;
import com.example.demo.repository.ProfileRepo;
import com.example.demo.service.ProfileService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(MockitoJUnitRunner.class)
public class TestProfileService {

    @Mock
    ProfileRepo repository;

    @Mock
    PasswordEncoder passwordEncoder;

    @InjectMocks
    ProfileService service;

    @Test
    public void createProfileTest() {
        Profile expectedProfile = new Profile();
        expectedProfile.setUsername("test username");
        expectedProfile.setPassword(passwordEncoder.encode("test password"));

        Mockito.when(repository.save(Mockito.any(Profile.class))).thenReturn(new Profile());
        Profile actualProfile = service.createProfile(expectedProfile);

        Assert.assertEquals(expectedProfile.getFirstName(), actualProfile.getFirstName());
    }

    @Test
    public void findByIdTest() {
        Long id = 5L;
        Profile expectedProfile = new Profile();
        expectedProfile.setId(id);

        Mockito.when(repository.getById(id)).thenReturn(expectedProfile);
        Profile actualProfile = service.findById(id);

        Assert.assertEquals(expectedProfile.getId(), actualProfile.getId());
    }

    @Test
    public void findAllProfilesTest() {
        List<Profile> expectedProfiles = new ArrayList<>();
        expectedProfiles.add(new Profile()); expectedProfiles.add(new Profile()); expectedProfiles.add(new Profile()); expectedProfiles.add(new Profile());

        Mockito.when(repository.findAll()).thenReturn(expectedProfiles);
        List<Profile> actualProfiles = service.findAllProfiles();

        Assert.assertEquals(expectedProfiles, actualProfiles);
    }

    @Test
    public void loginTest() {
        Profile expectedProfile = new Profile();
        String username = "test username";
        String password = passwordEncoder.encode("test password");
        expectedProfile.setPassword(password);
        expectedProfile.setUsername(username);

        Mockito.when(repository.findByUsernameAndPassword(username, password)).thenReturn(expectedProfile);
        Profile actualProfile = service.login(username, password);

        Assert.assertEquals(expectedProfile.getUsername(), actualProfile.getUsername());
    }

    @Test
    public void updateTest() {
        Profile expectedProfile = new Profile();
        expectedProfile.setUsername("test username");
        expectedProfile.setPassword(passwordEncoder.encode("test password"));

        Mockito.when(repository.save(Mockito.any(Profile.class))).thenReturn(new Profile());
        Profile actualProfile = service.update(expectedProfile);

        Assert.assertEquals(expectedProfile.getFirstName(), actualProfile.getFirstName());
    }

    @Test
    public void deleteByIdTest() {
        Profile profile = new Profile();
        Long id = 4L;
        profile.setId(id);

        service.deleteProfileById(id);
        service.deleteProfileById(id);

        Mockito.verify(repository, Mockito.times(2)).deleteById(id);
    }
}
