package com.estanciero.api.services;

import com.estanciero.api.models.entities.Game;
import com.estanciero.api.models.entities.Player;
import com.estanciero.api.models.entities.Turn;

import java.util.List;

public interface TurnService {
    List<Player> randomTurnOrder(List<Player> players);

    Player firstPlayer (List<Player> orderPlayers);
}
