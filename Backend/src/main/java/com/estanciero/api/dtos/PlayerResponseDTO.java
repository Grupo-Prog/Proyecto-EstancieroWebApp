package com.estanciero.api.dtos;

import com.estanciero.api.models.enums.BotDifficultyType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerResponseDTO {

    private Long id;

    private String color;

    private Double cash;

    private Integer position;

    private String playerType;

    private Long userId;

    private String name;

    private BotDifficultyType difficulty;
}
