package com.estanciero.api.factories;

import com.estanciero.api.models.entities.Game;
import com.estanciero.api.models.entities.Player_bot;
import com.estanciero.api.models.entities.Player_human;
import com.estanciero.api.models.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
@RequiredArgsConstructor
public class PlayerFactory {
    private static final Double INITIAL_CASH = 35000.0;
    private final BotNameProvider botNameProvider;

    public Player_human createHumanPlayer(Game game, User user) {
        return Player_human.builder()
                .game(game)
                .user(user)
                .cash(INITIAL_CASH)
                .properties(new ArrayList<>())
                .build();
    }

    //Para mas tarde
    public Player_bot createBotPlayer(Game game) {
        String botName = botNameProvider.getUniqueName(game);
        return Player_bot.builder()
                .name(botName)
                .game(game)
                .cash(INITIAL_CASH)
                .build();
    }
}
