package com.estanciero.api.services;

import com.estanciero.api.models.entities.Game;

public interface LobbyService {
    Game createGame(Long userId);
}
