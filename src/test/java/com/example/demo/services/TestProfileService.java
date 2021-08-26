package com.example.demo.services;

import com.example.demo.DemoApplication;
import com.example.demo.models.Channel;
import com.example.demo.models.Profile;
import com.example.demo.service.ProfileService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class TestProfileService {

    @Autowired
    private ProfileService service;

    Long expectedId = 1L;
    String expectedFirstName = "Ben";
    String expectedLastName = "Smith";
    String expectedUsername = "Batman";
    String expectedPassword = "Secret";
    String expectedEmail = "bens@gmail.com";
    List<Channel> expectedChannels = Stream.of(new Channel(), new Channel(), new Channel(), new Channel()).collect(Collectors.toList());
    Profile mockProfile = new Profile(expectedId, expectedFirstName, expectedLastName, expectedUsername, expectedPassword, expectedEmail, expectedChannels);

    @Test
    public void createProfileTest() {
        Mockito.when(service.createProfile(mockProfile)).thenReturn(mockProfile);
        String actualFirstName = service.createProfile(mockProfile).getFirstName();
        Assert.assertEquals(expectedFirstName, actualFirstName);
    }
}
