package com.estanciero.api.services.impl;

import com.estanciero.api.dtos.game.GameResponseDTO;
import com.estanciero.api.factories.BotFactory;
import com.estanciero.api.factories.BotNameProvider;
import com.estanciero.api.factories.ColorProvider;
import com.estanciero.api.mappers.GameMapper;
import com.estanciero.api.models.entities.*;
import com.estanciero.api.models.entities.boxes.Box;
import com.estanciero.api.models.entities.boxes.PropertyBox;
import com.estanciero.api.models.enums.BotDifficultyType;
import com.estanciero.api.models.enums.ColorType;
import com.estanciero.api.models.enums.GameStatusType;
import com.estanciero.api.repositories.BoardRepository;
import com.estanciero.api.repositories.BoxRepository;
import com.estanciero.api.repositories.GameRepository;
import com.estanciero.api.services.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@RequiredArgsConstructor
@Transactional
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final BoxRepository boxRepository;
    private final BoardRepository boardRepository;
    private final ColorProvider colorProvider;
    private final GameMapper gameMapper;
    private final BotFactory botFactory;
    private final BotNameProvider botNameProvider;


    @Override
    @Transactional
    public GameResponseDTO startGame(Long gameId) {
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new IllegalArgumentException("Game not found"));

        if (game.getStatusType() != GameStatusType.LOBBY) {
            throw new IllegalStateException("you can no longer join sorry");
        }

        if (game.getPlayers().size() < 2) {
            throw new IllegalStateException("requires at least 2 players");
        }

        // asigno colores random SOLO a los players o bots que no tengan colores seleccionados
        colorProvider.assignRandomColors(game);

        for (Player player : game.getPlayers()) {
            player.setCash(35000.0);
            player.setPosition(1);
        }

        // create board
        Board board = createBoard(game);
        game.setBoard(board);


        // Determine first player
        /*Player firstPlayer = determineFirstPlayer(game.getPlayers());?? */


        // change state
        game.setStatusType(GameStatusType.PLAYING);


        return gameMapper.toResponseDTO(game, null);
    }



    @Override
    public Game addBot(Long gameId, BotDifficultyType botDifficultyTypes) {
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new IllegalArgumentException("Game not found"));

        if (game.getPlayers().size() >= 6) {
            throw new IllegalStateException("This lobby is full sorry");
        }

        Player_bot bot = (Player_bot) botFactory.createBot(botDifficultyTypes, game);
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

    private Board createBoard( Game game) {
        Board board = new Board();
        board.setGame(game);

        List<Box> boxes = boxRepository.findAllByOrderByPositionAsc();

        for (Box box : boxes) {
            box.setBoard(board);

            if (box instanceof PropertyBox p) {
                p.setOwner(null);
                p.setChacrasCount(0);
                p.setHasEstancia(false);
                p.setIsMortgage(false);
            }
            boxRepository.save(box);
        }

        board.setBoxes(boxes);

        return boardRepository.save(board);

    }










}


