package com.estanciero.api.models.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "card_effects")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CardEffect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Carta dueña del efecto
    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    // mover x cantidad de casillas
    private Integer amountBoxes;

    // ir hacia box_id
    private Integer toBoxId;

    // levantar x plata
    private Double cash;
}
