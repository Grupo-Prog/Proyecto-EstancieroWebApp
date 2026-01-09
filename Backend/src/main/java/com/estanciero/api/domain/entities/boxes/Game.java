package com.estanciero.api.domain.entities.boxes;

import com.estanciero.api.domain.entities.Board;
import com.estanciero.api.domain.entities.Player;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "games")
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)

public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Player> players = new ArrayList<>();

    @OneToOne(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private Board board;
}
