package com.estanciero.api.services.impl;

import com.estanciero.api.factories.GameFactory;
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

}
