package com.estanciero.api.dtos;

import com.estanciero.api.models.entities.Board;
import com.estanciero.api.models.entities.Player;
import com.estanciero.api.models.enums.GameStatusType;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameResponseDTO {

    private Long id;

    private List<PlayerResponseDTO> players;

    private Long currentTurnPlayerId;

    private BoardResponseDTO board;

    private GameStatusType status;
}
