package com.estanciero.api.mappers;

import com.estanciero.api.dtos.PlayerResponseDTO;
import com.estanciero.api.models.entities.Player;

public class PlayerMapper {

    public static PlayerResponseDTO toDTO(Player player) {
        return PlayerResponseDTO.builder()
                .id(player.getId())
                .name(player.getName())
                .color(player.getColor())
                .cash(player.getCash())
                .position(player.getPosition())
                .build();
    }
}
