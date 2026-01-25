package com.estanciero.api.services.impl;

import com.estanciero.api.dtos.UserResponseDTO;
import com.estanciero.api.factories.GameFactory;
import com.estanciero.api.factories.PlayerFactory;
import com.estanciero.api.models.entities.Game;
import com.estanciero.api.models.entities.Player_human;
import com.estanciero.api.models.entities.User;

import com.estanciero.api.models.enums.GameStatusType;
import com.estanciero.api.repositories.GameRepository;
import com.estanciero.api.repositories.UserRepository;
import com.estanciero.api.services.LobbyService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


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
        User user = userRepository.findById(userId).orElseThrow(()
                -> new IllegalArgumentException("User not found"));
        //crear juego con host
        var game = gameFactory.createGameWithHost(user);
        //guardar
        return gameRepository.save(game);
    }


    @Override
    public Game joinGame(Long gameId, Long userId) {
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new IllegalArgumentException("Game not found"));

        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (game.getStatusType() != GameStatusType.LOBBY) {
            throw new IllegalStateException("You can no longer join sorry");
        }

        if (game.getPlayers().size() >= 6) {
            throw new IllegalStateException("This lobby is full");
        }

        var player = playerFactory.createHumanPlayer(game, user);
        game.getPlayers().add(player);

        return gameRepository.save(game);
    }


}
