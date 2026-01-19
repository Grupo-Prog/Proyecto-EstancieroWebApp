package com.estanciero.api.services;

import com.estanciero.api.dtos.GameRequestDTO;
import com.estanciero.api.dtos.GameResponseDTO;
import com.estanciero.api.models.entities.Game;

import java.util.List;
import java.util.Optional;

public interface GameService {

    Game createGame(Long userId);

    Game startGame(Long gameId);

    Game joinGame(Long gameId, Long userId);

    Optional<Game> findById(Long gameId);

    List<Game> findAll();
}
