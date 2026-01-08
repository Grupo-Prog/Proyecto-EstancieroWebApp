package com.estanciero.api.domain.entities.boxes;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class SpecialBox {
    @Id
    private Long id;

}
