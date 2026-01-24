package com.estanciero.api.services.impl;

import com.estanciero.api.dtos.UserResponseDTO;
import com.estanciero.api.mappers.UserMapper;
import com.estanciero.api.models.entities.*;
import com.estanciero.api.models.enums.BotDifficultyType;
import com.estanciero.api.models.enums.ColorType;
import com.estanciero.api.models.enums.GameStatusType;
import com.estanciero.api.repositories.GameRepository;
import com.estanciero.api.repositories.UserRepository;
import com.estanciero.api.services.GameService;
import com.estanciero.api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepo;
    private final UserService userService;
    private final UserMapper userMapper;


    @Override
    public Game joinGame(Long gameId, Long userId) {
        Game game = gameRepo.findById(gameId).orElseThrow(() -> new IllegalArgumentException("Game not found"));
        UserResponseDTO userResponseDTO = userService.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        User user = userMapper.toEntity(userResponseDTO);

        if (game.getStatusType() != GameStatusType.LOBBY) {
            throw new IllegalStateException("You can no longer join sorry");
        }

        if (game.getPlayers().size() >= 6) {
            throw new IllegalStateException("This lobby is full");
        }

        Player_human player = new Player_human();
        player.setUser(user);
        player.setGame(game);
        player.setCash(0.0);
        player.setPosition(0);
        player.setProperties(new ArrayList<>());

        game.getPlayers().add(player);

        return gameRepo.save(game);
    }

    @Override
    public Game addBot(Long gameId, BotDifficultyType botDifficultyTypes) {
        Game game = gameRepo.findById(gameId).orElseThrow(() -> new IllegalArgumentException("Game not found"));
        if (game.getPlayers().size() >= 6) {
            throw new IllegalStateException("This lobby is full sorry");
        }
        Player_bot bot = new Player_bot();
        bot.setGame(game);
        bot.setCash(0.0);
        bot.setPosition(0);
        bot.setDifficulty(botDifficultyTypes);
        bot.setProperties(new ArrayList<>());

        game.getPlayers().add(bot);
        return gameRepo.save(game);
    }

    @Override
    public Game removeBot(Long gameId, Long playerId) {
        Game game = gameRepo.findById(gameId).orElseThrow(() -> new IllegalArgumentException("Game not found"));
        if (game.getStatusType() != GameStatusType.LOBBY) {
            throw new IllegalStateException("Bots can only be removed in the lobby");
        }

        for (int i = 0; i < game.getPlayers().size(); i++) {
            Player p = game.getPlayers().get(i);

            if (p.getId().equals(playerId)){
                game.getPlayers().remove(i);
            }

        }
        return gameRepo.save(game);
    }

    @Override
    public Optional<Game> findById(Long gameId) {
        return gameRepo.findById(gameId);
    }

    @Override
    public List<Game> findAll() {
        return gameRepo.findAll();
    }

    /*private Player determineFirstPlayer(List<Player> players) {
        Random random = new Random();
        return winners??????
    }*/

    /*private void <assignColors(List<Player> players)> {
    }*/
}


