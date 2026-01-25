package com.estanciero.api.services.impl;

import com.estanciero.api.factories.GameFactory;
import com.estanciero.api.factories.PlayerFactory;
import com.estanciero.api.models.entities.Game;
import com.estanciero.api.models.entities.User;


import com.estanciero.api.repositories.GameRepository;
import com.estanciero.api.repositories.UserRepository;
import com.estanciero.api.services.LobbyService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class LobbyServiceImpl implements LobbyService {

    private final GameRepository gameRepository;
    private final UserRepository userRepository;
    private final GameFactory gameFactory;
    private final PlayerFactory playerFactory;

    @Override
    public Game createGame(Long userId) {
        //verificar que existe el user
        User user = findUserOrThrow(userId);
        //crear juego con host
        var game = gameFactory.createGameWithHost(user);
        //guardar
        return gameRepository.save(game);
    }


    @Override
    public Game joinGame(Long gameId, Long userId) {
        //verificar que existe el game
        var game = findGameOrThrow(gameId);
        //verificar que se puede unir
        game.validateJoinability(userId);

        User user = findUserOrThrow(userId);

        var player = playerFactory.createHumanPlayer(game, user);
        //agregar el jugador
        game.getPlayers().add(player);

        //guardar
        return gameRepository.save(game);
    }

    private Game findGameOrThrow(Long gameId) {
        return gameRepository.findById(gameId).orElseThrow(()
                -> new IllegalArgumentException("Game not found"));
    }

    private User findUserOrThrow(Long userId) {
        return userRepository.findById(userId).orElseThrow(()
                -> new IllegalArgumentException("User not found"));
    }
}
