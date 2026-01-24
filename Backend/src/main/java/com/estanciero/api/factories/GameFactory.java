package com.estanciero.api.factories;

import com.estanciero.api.models.entities.Game;
import com.estanciero.api.models.entities.User;
import com.estanciero.api.models.enums.GameStatusType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class GameFactory {
    private final PlayerFactory playerFactory;

    public Game createGameWithHost(User hostUser) {
        var game = Game.builder()
                .statusType(GameStatusType.LOBBY)
                .players(new ArrayList<>())
                .build();

        var hostPlayer = playerFactory.createHumanPlayer(game, hostUser);
        game.getPlayers().add(hostPlayer);
        return game;
    }
}
