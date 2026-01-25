package com.estanciero.api.services.impl;

import com.estanciero.api.dtos.UserResponseDTO;
import com.estanciero.api.mappers.UserMapper;
import com.estanciero.api.models.entities.*;
import com.estanciero.api.models.enums.BotDifficultyType;
import com.estanciero.api.models.enums.ColorType;
import com.estanciero.api.models.enums.GameStatusType;
import com.estanciero.api.repositories.GameRepository;
import com.estanciero.api.services.GameService;
import com.estanciero.api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@RequiredArgsConstructor
@Transactional
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final UserService userService;
    private final UserMapper userMapper;


    @Override
    @Transactional
    public Game startGame(Long gameId) {
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new IllegalArgumentException("Game not found"));

        if (game.getStatusType() != GameStatusType.LOBBY) {
            throw new IllegalStateException("you can no longer join sorry");
        }

        if (game.getPlayers().size() < 2) {
            throw new IllegalStateException("requires at least 2 players");
        }

        List<ColorType> colorsAvailable = new ArrayList<>(Arrays.asList(ColorType.values()));
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

        return gameRepository.save(game);
    }



    @Override
    public Game addBot(Long gameId, BotDifficultyType botDifficultyTypes) {
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new IllegalArgumentException("Game not found"));
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
        return gameRepository.save(game);
    }

    @Override
    public Game removeBot(Long gameId, Long playerId) {
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new IllegalArgumentException("Game not found"));
        if (game.getStatusType() != GameStatusType.LOBBY) {
            throw new IllegalStateException("Bots can only be removed in the lobby");
        }

        for (int i = 0; i < game.getPlayers().size(); i++) {
            Player p = game.getPlayers().get(i);

            if (p.getId().equals(playerId)){
                game.getPlayers().remove(i);
            }

        }
        return gameRepository.save(game);
    }

    @Override
    public Optional<Game> findById(Long gameId) {
        return gameRepository.findById(gameId);
    }

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    /*private Player determineFirstPlayer(List<Player> players) {
        Random random = new Random();
        return winners??????
    }*/

    /*private void <assignColors(List<Player> players)> {
    }*/
}


