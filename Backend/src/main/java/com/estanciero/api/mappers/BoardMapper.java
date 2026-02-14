package com.estanciero.api.mappers;

import com.estanciero.api.dtos.BoardResponseDTO;
import com.estanciero.api.models.entities.Board;

import java.util.stream.Collectors;

public class BoardMapper {

    public static BoardResponseDTO toDTO(Board board) {
        return BoardResponseDTO.builder()
                .id(board.getId())
                .boxes(
                        board.getBoxes()
                                .stream()
                                .map(BoxMapper::toDTO)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
