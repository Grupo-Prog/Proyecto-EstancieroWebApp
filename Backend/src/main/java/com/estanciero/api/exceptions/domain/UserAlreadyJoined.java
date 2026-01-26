package com.estanciero.api.exceptions.domain;

public class UserAlreadyJoined extends DomainException {
    public UserAlreadyJoined(String username) {
        super("The user: " + username + " is already joined.");
    }
}
