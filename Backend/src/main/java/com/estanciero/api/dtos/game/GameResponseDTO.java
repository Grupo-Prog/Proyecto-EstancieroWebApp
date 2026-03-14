package com.estanciero.api.dtos.game;

import com.estanciero.api.dtos.BoardResponseDTO;
import com.estanciero.api.dtos.PlayerResponseDTO;
import com.estanciero.api.models.enums.ColorType;
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

    private List<Long> turnOrder;

    private Integer currentTurnIndex;

    private BoardResponseDTO board;

    private GameStatusType status;

    private List<ColorType> availableColors;
}
