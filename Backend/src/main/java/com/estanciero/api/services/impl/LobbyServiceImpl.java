package com.estanciero.api.services.impl;

import com.estanciero.api.dtos.game.GameResponseDTO;
import com.estanciero.api.factories.ColorProvider;
import com.estanciero.api.factories.GameFactory;
import com.estanciero.api.factories.PlayerFactory;
import com.estanciero.api.mappers.GameMapper;
import com.estanciero.api.models.entities.Game;
import com.estanciero.api.models.entities.Player;
import com.estanciero.api.models.entities.User;


import com.estanciero.api.models.enums.ColorType;
import com.estanciero.api.models.enums.GameStatusType;
import com.estanciero.api.repositories.GameRepository;
import com.estanciero.api.repositories.UserRepository;
import com.estanciero.api.services.LobbyService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
@Transactional
public class LobbyServiceImpl implements LobbyService {

    private final GameRepository gameRepository;
    private final UserRepository userRepository;
    private final GameFactory gameFactory;
    private final PlayerFactory playerFactory;
    private final ColorProvider colorProvider;
    private final GameMapper gameMapper;

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


    @Override
    public List<ColorType> findAvailableColors(Long gameId) {
        var game = findGameOrThrow(gameId);
        return colorProvider.getAvailableColors(game);
    }


    @Override
    public Game addColor(Long gameId, Long playerId, ColorType color) {
        var game = findGameOrThrow(gameId);
        colorProvider.assignColorToPlayer(playerId, color, game);

        return gameRepository.save(game);
    }

    public GameResponseDTO getGame(Long gameId) {
        Game game = gameRepository.findById(gameId).orElseThrow();

        List<ColorType> availableColors = null;

        if (game.getStatusType() == GameStatusType.LOBBY) {
            availableColors = findAvailableColors(gameId);
        }

        return gameMapper.toResponseDTO(game, availableColors);
    }











}
