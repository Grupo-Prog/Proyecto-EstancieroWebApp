package com.estanciero.api.dtos;

import com.estanciero.api.models.entities.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoxResponseDTO {

    private String name;
    private Integer position;
    private String type;

    private Double purchasePrice;
    private Integer chacrasCount;
    private Boolean hasEstancia;
    private Boolean isMortgage;

    private PlayerResponseDTO owner;

}
