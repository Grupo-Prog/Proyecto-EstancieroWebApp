package com.estanciero.api.mappers;

import com.estanciero.api.dtos.BoxResponseDTO;
import com.estanciero.api.models.entities.boxes.Box;
import com.estanciero.api.models.entities.boxes.PropertyBox;

public class BoxMapper {

    public static BoxResponseDTO toDTO(Box box) {

        BoxResponseDTO.BoxResponseDTOBuilder dto = BoxResponseDTO.builder()
                .name(box.getName())
                .position(box.getPosition())
                .type(box.getClass().getSimpleName());

        if (box instanceof PropertyBox propertyBox) {
            dto.purchasePrice(propertyBox.getPurchasePrice());
            dto.chacrasCount(propertyBox.getChacrasCount());
            dto.hasEstancia(propertyBox.getHasEstancia());
            dto.isMortgage(propertyBox.getIsMortgage());

            dto.owner(
                    propertyBox.getOwner() != null
                            ? PlayerMapper.toDTO(propertyBox.getOwner())
                            : null
            );
        }

        return dto.build();
    }
}
