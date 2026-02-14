package com.estanciero.api.factories;

import com.estanciero.api.models.entities.Game;
import com.estanciero.api.models.entities.Player;
import com.estanciero.api.models.entities.Player_bot;
import com.estanciero.api.models.enums.BotDifficultyType;
import com.estanciero.api.models.enums.ColorType;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class BotFactory {

    private final BotNameProvider botNameProvider;
    private final ColorProvider colorProvider;

    public BotFactory(BotNameProvider botNameProvider, ColorProvider colorProvider) {
        this.botNameProvider = botNameProvider;
        this.colorProvider = colorProvider;
    }

    public Player createBot(BotDifficultyType difficulty, Game game) {
        String name = botNameProvider.getUniqueName(game);

        var availableColors = colorProvider.getAvailableColors(game);
        if (availableColors.isEmpty()) {
            throw new IllegalStateException("No colors available to assign to bot");
        }
        var color = availableColors.get((int) (Math.random() * availableColors.size()));

        Player_bot bot = Player_bot.builder()
                .name(name)
                .difficulty(difficulty)
                .color(color)
                .cash(35000.0)
                .position(0)
                .game(game)
                .build();

        return bot;

    }
}
