package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.catalina.User;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "profile_id",
                referencedColumnName = "id")
    Profile profile;
    String body;
    String timestamp;
    @ManyToOne
    @JoinColumn(name = "channel_id",
                referencedColumnName = "id")
    Channel channel;


    public Message() {
    }

    public Message(Long id, Profile profile, String body, String timestamp) {
        this.id = id;
        this.profile = profile;
        this.body = body;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
