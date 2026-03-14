package com.estanciero.api.services.impl;

import com.estanciero.api.models.entities.Player;
import com.estanciero.api.services.TurnService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TurnServiceImpl implements TurnService {


    @Override
    public List<Player> randomTurnOrder(List<Player> players) {
        List<Player> turnOrder = new ArrayList<>(players);

        Collections.shuffle(turnOrder);

        return turnOrder;
    }

    @Override
    public List<Long> getPlayerIds(List<Player> players) {
        List<Long> playersIds = new ArrayList<>();

        for (Player p : players) {
            playersIds.add(p.getId());
        }

        return playersIds;
    }

}
