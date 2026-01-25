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

    public static final Integer MAX_PLAYERS = 6;


    @Builder.Default
    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Player> players = new ArrayList<>();

    @OneToOne(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private Board board;

    @Enumerated(EnumType.STRING)
    private GameStatusType statusType;


    /**
     * Metodo creado para que la entidad
     * verifique por sí misma si se cumplen las condiciones para unirse o no
     *
     * @param userId Usuario que intenta unirse
     */
    public void validateJoinability(Long userId) {
        //chequear que no haya comenzado
        if (this.statusType != GameStatusType.LOBBY) {
            throw new IllegalArgumentException("The game is not in lobby");
        }
        //chequear que tenga lugar
        if (this.players.size() >= MAX_PLAYERS) {
            throw new IllegalStateException("The game is full");
        }
        //chequear que el usuario no ingresó todavía
        boolean alreadyJoined = this.players.stream().anyMatch(p -> p.getId().equals(userId));
        if (alreadyJoined) {
            throw new IllegalStateException("The user is already in this lobby");
        }
    }
}
