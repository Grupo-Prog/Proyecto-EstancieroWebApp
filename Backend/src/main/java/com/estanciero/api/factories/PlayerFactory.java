package com.estanciero.api.factories;

import com.estanciero.api.models.entities.Game;
import com.estanciero.api.models.entities.Player_bot;
import com.estanciero.api.models.entities.Player_human;
import com.estanciero.api.models.entities.User;
import org.springframework.stereotype.Component;


@Component
public class PlayerFactory {
    private static final Double INITIAL_CASH = 35000.0;

    public Player_human createHumanPlayer(Game game, User user) {
        return Player_human.builder()
                .game(game)
                .user(user)
                .cash(INITIAL_CASH)
                .build();
    }

    //Para mas tarde
    public Player_bot createBotPlayer() {
        return null;
    }
}
