package com.estanciero.api.models.entities;

import com.estanciero.api.models.enums.CardEffectType;
import com.estanciero.api.models.enums.CardType;
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

    // plata, mover x cantidad de casillas, ir hacia box_id
    private Integer amount;

    //boolean para guardar la card
    @Column(name = "can_be_kept")
    private Boolean canBeKept;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
}
