package com.estanciero.api.services;

import com.estanciero.api.models.entities.Game;
import com.estanciero.api.models.enums.ColorType;

import java.util.List;

public interface LobbyService {
    Game createGame(Long userId);
    Game joinGame(Long gameId, Long userId);
    List<ColorType> findAvailableColors(Long gameId);
    Game addColor(Long gameId, Long playerId, ColorType color);
}
