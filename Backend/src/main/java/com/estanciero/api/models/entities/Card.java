package com.estanciero.api.models.entities;


import com.estanciero.api.models.enums.CardType;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


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

    // 1 Card --> N Effects
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CardEffect> effects = new ArrayList<>();

    //boolean para guardar la card
    @Column(name = "can_be_kept")
    private Boolean canBeKept = false;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
}
