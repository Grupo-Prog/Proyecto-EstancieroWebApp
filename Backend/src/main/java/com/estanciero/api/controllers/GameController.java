package com.estanciero.api.controllers;


import com.estanciero.api.models.entities.Game;
import com.estanciero.api.models.enums.BotDifficultyType;
import com.estanciero.api.services.GameService;
import com.estanciero.api.services.LobbyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/games")
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;
    private final LobbyService lobbyService;

    @GetMapping
    public ResponseEntity<List<Game>> getAllGames() {
        List<Game> games = gameService.findAll();
        return ResponseEntity.ok(games);
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<Game> getGame(@PathVariable Long gameId) {
        return gameService.findById(gameId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Game> createGame(@RequestBody Map<String, Long> request) {
        Long userId = request.get("userId");
        if (userId == null) {
            return ResponseEntity.badRequest().build();
        }
        try {
            Game game = lobbyService.createGame(userId);
            return ResponseEntity.status(HttpStatus.CREATED).body(game);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{gameId}/start")
    public ResponseEntity<Game> startGame(@PathVariable Long gameId) {
        try {
            Game game = gameService.startGame(gameId);
            return ResponseEntity.ok(game);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{gameId}/join")
    public ResponseEntity<Game> joinGame(@PathVariable Long gameId, @RequestBody Map<String, Long> request) {
        Long userId = request.get("userId");
        if (userId == null) {
            return ResponseEntity.badRequest().build();
        }
        try {
            Game game = gameService.joinGame(gameId, userId);
            return ResponseEntity.ok(game);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{gameId}/addBot")
    public ResponseEntity<Game> addBot(@PathVariable Long gameId, @RequestBody Map<String, String> request) {
        if (gameId == null) {
            return ResponseEntity.badRequest().build();
        }
        try {
            String difficulty = request.get("difficulty");
            BotDifficultyType botDifficultyType = BotDifficultyType.valueOf(difficulty);
            Game game = gameService.addBot(gameId, botDifficultyType);
            return ResponseEntity.ok(game);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{gameId}/removeBot/{botId}")
    public ResponseEntity<Game> removeBot(@PathVariable Long gameId, @PathVariable Long botId) {
        try {
            Game game = gameService.removeBot(gameId, botId);
            return ResponseEntity.ok(game);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
