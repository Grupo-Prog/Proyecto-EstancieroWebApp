package com.estanciero.api.domain.entities;

import com.estanciero.api.domain.entities.boxes.Box;
import com.estanciero.api.domain.entities.boxes.Game;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "boards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long currentTurnPlayerId;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("position ASC")
    private List<Box> boxes = new ArrayList<>();

    @OneToOne()
    @JoinColumn(name = "game_id")
    private Game game;
}
