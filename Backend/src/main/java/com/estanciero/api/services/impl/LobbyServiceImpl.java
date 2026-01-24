package com.estanciero.api.services.impl;

import com.estanciero.api.dtos.UserResponseDTO;
import com.estanciero.api.mappers.UserMapper;
import com.estanciero.api.models.entities.Game;
import com.estanciero.api.models.entities.Player;
import com.estanciero.api.models.entities.Player_human;
import com.estanciero.api.models.entities.User;
import com.estanciero.api.models.enums.ColorType;
import com.estanciero.api.models.enums.GameStatusType;
import com.estanciero.api.repositories.GameRepository;
import com.estanciero.api.services.LobbyService;
import com.estanciero.api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LobbyServiceImpl implements LobbyService {

    private final GameRepository gameRepo;
    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    @Transactional()
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

    @Override
    @Transactional
    public Game startGame(Long gameId) {
        Game game = gameRepo.findById(gameId).orElseThrow(() -> new IllegalArgumentException("Game not found"));

        if (game.getStatusType() != GameStatusType.LOBBY) {
            throw new IllegalStateException("you can no longer join sorry");
        }

        if (game.getPlayers().size() < 2) {
            throw new IllegalStateException("requires at least 2 players");
        }

        List<ColorType> colorsAvailable  = new ArrayList<>(Arrays.asList(ColorType.values()));
        Collections.shuffle(colorsAvailable);

        for (Player player : game.getPlayers()) {
            if (player.getColor() == null) {
                ColorType color = colorsAvailable.get(0);
                player.setColor(color);
                colorsAvailable.remove(0);
            }
            player.setCash(35000.0);
            player.setPosition(1);
        }

        // create board
        /*Board board = createBoard(game);

        // Determine first player
        /*Player firstPlayer = determineFirstPlayer(game.getPlayers());?? */


        // change state
        game.setStatusType(GameStatusType.PLAYING);

        return gameRepo.save(game);
    }

}
