package com.estanciero.api.controllers;


import com.estanciero.api.dtos.AddColorRequestDTO;
import com.estanciero.api.dtos.game.CreateGameDTO;
import com.estanciero.api.dtos.game.JoinGameDto;
import com.estanciero.api.models.entities.Game;
import com.estanciero.api.models.enums.BotDifficultyType;
import com.estanciero.api.models.enums.ColorType;
import com.estanciero.api.services.GameService;
import com.estanciero.api.services.LobbyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/games")
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;
    private final LobbyService lobbyService;

    @GetMapping
    public ResponseEntity<List<Game>> getAllGames() {
        return ResponseEntity.ok(gameService.findAll());
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<Game> getGame(@PathVariable Long gameId) {
        Game game = gameService.findById(gameId).orElseThrow(()
                -> new NoSuchElementException("Game ID not found: " + gameId));
        return ResponseEntity.ok(game);
    }

    @PostMapping
    public ResponseEntity<Game> createGame(@Valid @RequestBody CreateGameDTO request) {

        Game game = lobbyService.createGame(request.hostUserId());
        return ResponseEntity.status(HttpStatus.CREATED).body(game);
    }

    @PostMapping("/{gameId}/start")
    public ResponseEntity<Game> startGame(@PathVariable Long gameId) {
        Game game = gameService.startGame(gameId);
        return ResponseEntity.ok(game);
    }

    @PostMapping("/{gameId}/join")
    public ResponseEntity<Game> joinGame(@PathVariable Long gameId,
                                         @Valid @RequestBody JoinGameDto request) {

        Game game = lobbyService.joinGame(gameId, request.userId());
        return ResponseEntity.ok(game);
    }

    @PostMapping("/{gameId}/addBot")
    public ResponseEntity<Game> addBot(@PathVariable Long gameId, @RequestBody Map<String, String> request) {

        String difficulty = request.get("difficulty");
        if (difficulty == null) {
            throw new IllegalArgumentException("Difficulty is required");
        }

        BotDifficultyType botDifficultyType = BotDifficultyType.valueOf(difficulty);
        Game game = gameService.addBot(gameId, botDifficultyType);

        return ResponseEntity.ok(game);
    }

    @PutMapping("/{gameId}/removeBot/{botId}")
    public ResponseEntity<Game> removeBot(@PathVariable Long gameId, @PathVariable Long botId) {
        Game game = gameService.removeBot(gameId, botId);
        return ResponseEntity.ok(game);
    }


    @PostMapping("/{gameId}/addColor")
    public ResponseEntity<Game> addColor(@PathVariable Long gameId,
                                         @RequestBody AddColorRequestDTO request) {

        Game game = lobbyService.addColor(gameId, request.getPlayerId(), request.getColor());
        return ResponseEntity.ok(game);
    }


    @GetMapping("/{gameId}/colors")
    public ResponseEntity<List<ColorType>> getAvailableColors(@PathVariable Long gameId) {
        List<ColorType> colors = lobbyService.findAvailableColors(gameId);
        return ResponseEntity.ok(colors);
    }

}
