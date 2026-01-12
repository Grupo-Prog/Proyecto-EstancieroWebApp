package com.estanciero.api.models.entities.boxes;

import com.estanciero.api.models.enums.SpecialBoxType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("SPECIAL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpecialBox extends Box {

    @Enumerated(EnumType.STRING)
    private SpecialBoxType type;

}
