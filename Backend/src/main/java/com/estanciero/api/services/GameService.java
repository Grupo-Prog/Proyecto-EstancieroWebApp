package com.estanciero.api.services;

import com.estanciero.api.dtos.game.GameResponseDTO;
import com.estanciero.api.models.entities.Game;
import com.estanciero.api.models.enums.BotDifficultyType;

import java.util.List;
import java.util.Optional;

public interface GameService {



    GameResponseDTO startGame(Long gameId);



    Game addBot(Long gameId, BotDifficultyType botDifficultyTypes);

    Game removeBot(Long gameId, Long botId);

    Optional<Game> findById(Long gameId);

    List<Game> findAll();
}
