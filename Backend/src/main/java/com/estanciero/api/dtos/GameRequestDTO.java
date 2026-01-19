package com.estanciero.api.dtos;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GameRequestDTO {

    private Long userId;
}
