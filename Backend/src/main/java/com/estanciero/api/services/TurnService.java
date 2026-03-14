package com.estanciero.api.services;

import com.estanciero.api.models.entities.Player;

import java.util.List;

public interface TurnService {
    List<Player> randomTurnOrder(List<Player> players);

    List<Long> getPlayerIds (List<Player> players);
}
