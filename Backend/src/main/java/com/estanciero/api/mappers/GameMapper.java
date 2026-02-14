package com.estanciero.api.mappers;

import com.estanciero.api.dtos.BoardResponseDTO;
import com.estanciero.api.dtos.game.GameResponseDTO;
import com.estanciero.api.models.entities.Board;
import com.estanciero.api.models.entities.Game;
import com.estanciero.api.models.enums.ColorType;
import com.estanciero.api.services.LobbyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GameMapper {


    public GameResponseDTO toResponseDTO(Game game, List<ColorType> availableColors) {
        return GameResponseDTO.builder()
                .id(game.getId())
                .status(game.getStatusType())
                .currentTurnPlayerId(game.getCurrentTurnPlayerId())
                .players(
                        game.getPlayers()
                                .stream()
                                .map(PlayerMapper::toDTO)
                                .toList()
                )
                .board(toBoardDTO(game.getBoard()))
                .availableColors(availableColors)
                .build();
    }

    public BoardResponseDTO toBoardDTO(Board board) {
        return BoardResponseDTO.builder()
                .id(board.getId())
                .boxes(board.getBoxes().stream()
                        .map(BoxMapper::toDTO)
                        .collect(Collectors.toList()))
                .build();
    }

}
