package com.estanciero.api.exceptions.domain;

public class GameFullException extends DomainException {
    public GameFullException(Long gameId) {
        super("Game with ID: " + gameId + " is already full.");
    }
}

