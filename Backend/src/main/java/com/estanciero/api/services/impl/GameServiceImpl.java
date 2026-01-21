package com.estanciero.api.services.impl;

import com.estanciero.api.models.entities.*;
import com.estanciero.api.models.enums.BotDifficultyType;
import com.estanciero.api.models.enums.GameStatusType;
import com.estanciero.api.repositories.GameRepository;
import com.estanciero.api.repositories.UserRepository;
import com.estanciero.api.services.GameService;
import com.estanciero.api.services.UserService;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepo;
    private final UserService userService;
    private final UserRepository userRepo;

    public GameServiceImpl(GameRepository gameRepo, UserService userService, UserRepository userRepo) {
        this.gameRepo = gameRepo;
        this.userService = userService;
        this.userRepo = userRepo;
    }


    @Override
    public Game createGame(Long userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

        Game game = new Game();
        game.setStatusType(GameStatusType.LOBBY);
        game.setPlayers(new ArrayList<>());

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
    public Game startGame(Long gameId) {
        Game game = gameRepo.findById(gameId).orElseThrow(() -> new IllegalArgumentException("Game not found"));

        if (game.getStatusType() != GameStatusType.LOBBY) {
            throw new IllegalStateException("you can no longer join sorry");
        }

        if (game.getPlayers().size() < 2) {
            throw new IllegalStateException("requires at least 2 players");
        }

        //assignColors
        // assignColors(List<Player> players)??

        // Cash and position
        for (Player player : game.getPlayers()) {
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

    @Override
    public Game joinGame(Long gameId, Long userId) {
        Game game = gameRepo.findById(gameId).orElseThrow(() -> new IllegalArgumentException("Game not found"));
        User user = userRepo.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

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
        List<String> availableColors = new ArrayList<>(Arrays.asList(
                "ROJO", "AZUL", "VERDE", "AMARILLO", "NARANJA", "VIOLETA"
        ));
    }*/
}


