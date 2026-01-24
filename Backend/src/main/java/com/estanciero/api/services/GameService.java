package com.estanciero.api.services;

import com.estanciero.api.models.entities.Game;
import com.estanciero.api.models.enums.BotDifficultyType;

import java.util.List;
import java.util.Optional;

public interface GameService {



    Game startGame(Long gameId);

    Game joinGame(Long gameId, Long userId);

    Game addBot(Long gameId, BotDifficultyType botDifficultyTypes);

    Game removeBot(Long gameId, Long botId);

    Optional<Game> findById(Long gameId);

    List<Game> findAll();
}
