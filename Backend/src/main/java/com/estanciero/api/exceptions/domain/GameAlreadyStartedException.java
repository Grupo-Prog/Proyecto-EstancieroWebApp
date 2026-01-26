package com.estanciero.api.exceptions.domain;

public class GameAlreadyStartedException extends DomainException {
    public GameAlreadyStartedException() {
        super("You can not join. Game already started.");
    }
}
