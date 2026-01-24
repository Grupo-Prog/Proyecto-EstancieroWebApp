package com.estanciero.api.services.impl;

import com.estanciero.api.dtos.UserResponseDTO;
import com.estanciero.api.mappers.UserMapper;
import com.estanciero.api.models.entities.Game;
import com.estanciero.api.models.entities.Player_human;
import com.estanciero.api.models.entities.User;
import com.estanciero.api.models.enums.GameStatusType;
import com.estanciero.api.repositories.GameRepository;
import com.estanciero.api.services.LobbyService;
import com.estanciero.api.services.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class LobbyServiceImpl implements LobbyService {

    private final GameRepository gameRepo;
    private final UserService userService;
    private final UserMapper userMapper;

    public LobbyServiceImpl(GameRepository gameRepo, UserService userService, UserMapper userMapper) {
        this.gameRepo = gameRepo;
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public Game createGame(Long userId) {
        UserResponseDTO userResponseDTO = userService.findById(userId).orElseThrow(()
                -> new IllegalArgumentException("User not found"));
        User user = userMapper.toEntity(userResponseDTO);

        Game game = new Game();

        game.setStatusType(GameStatusType.LOBBY);
        game.setPlayers(new ArrayList<>());

        Player_human player = new Player_human();
        player.setUser(user);
        player.setGame(game);

        game.getPlayers().add(player);

        return gameRepo.save(game);
    }

}
