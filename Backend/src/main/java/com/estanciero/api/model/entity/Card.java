package com.estanciero.api.model.entity;

import com.estanciero.api.model.enums.CardEffectType;
import com.estanciero.api.model.enums.CardType;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "cards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CardType type;

    private String description;

    @Enumerated(EnumType.STRING)
    private CardEffectType effectType;

    // plata, cantidad de casillas
    private Integer value;

    //boolean para guardar la card
    private Boolean canBeKept;
}
