package com.estanciero.api.mappers;

import com.estanciero.api.dtos.BoxResponseDTO;
import com.estanciero.api.models.entities.boxes.Box;

public class BoxMapper {

    public static BoxResponseDTO toDTO(Box box) {
        return BoxResponseDTO.builder()
                .position(box.getPosition())
                .name(box.getName())
                .type(box.getClass().getSimpleName())
                .build();
    }
}
