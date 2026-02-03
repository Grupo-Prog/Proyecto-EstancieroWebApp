package com.estanciero.api.dtos;

import com.estanciero.api.models.enums.ColorType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddColorRequestDTO {

    private Long playerId;

    private ColorType color;
}
