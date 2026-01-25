package com.estanciero.api.models.entities;

import com.estanciero.api.models.enums.GameStatusType;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "games")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(onlyExplicitlyIncluded = true)

public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //campo que sirve para controlar la concurrencia
    @Version
    private Long version;

    private Long currentTurnPlayerId;

    @Builder.Default
    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Player> players = new ArrayList<>();

    @OneToOne(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private Board board;

    @Enumerated(EnumType.STRING)
    private GameStatusType statusType;
}
