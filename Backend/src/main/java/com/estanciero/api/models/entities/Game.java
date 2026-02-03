package com.estanciero.api.models.entities;

import com.estanciero.api.exceptions.domain.GameAlreadyStartedException;
import com.estanciero.api.exceptions.domain.GameFullException;
import com.estanciero.api.exceptions.domain.UserAlreadyJoined;
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
            throw new GameAlreadyStartedException();
        }
        //chequear que tenga lugar
        if (this.players.size() >= MAX_PLAYERS) {
            throw new GameFullException(this.id);
        }

        //chequear que si algún player le pertenece ya al usuario
        var existingPlayerOpt = this.players.stream()
                .filter(p -> p.isUser(userId))
                .findFirst();
        
        if (existingPlayerOpt.isPresent()) {
            String userName = existingPlayerOpt.get().getName();
            throw new UserAlreadyJoined(userName);
        }
    }

    /**
     * Metodo creado para verificar que un player existe en un game
     * @param playerId Player que se busca
     */
    public Player findPlayerOrThrow(Long playerId) {
        return this.players.stream()
                .filter(p -> p.getId().equals(playerId))
                .findFirst()
                .orElseThrow(()
                        -> new IllegalArgumentException("player not found in this game"));
    }
}
