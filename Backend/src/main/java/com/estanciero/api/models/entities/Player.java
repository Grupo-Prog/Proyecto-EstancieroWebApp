package com.estanciero.api.models.entities;

import com.estanciero.api.models.entities.boxes.PropertyBox;
import com.estanciero.api.models.enums.ColorType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "players")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@DiscriminatorColumn(name = "PLAYER_TYPE", discriminatorType = DiscriminatorType.STRING)
@ToString(onlyExplicitlyIncluded = true)
public abstract class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ColorType color;

    @Builder.Default
    private Double cash = 0.0;

    @Builder.Default
    private Integer position = 0;

    /**
     * Metodo abstracto para obtener el nombre de un jugador
     *
     * @return nombre del usuario o un nombre random si es un bot
     */
    public abstract String getName();

    /**
     * Metodo abstracto para validar que el jugador le pertenece a un usuario
     */
    public abstract boolean isUser(Long userId);

    @ManyToOne
    @JoinColumn(name = "game_id")
    @JsonIgnore
    private Game game;

    @Builder.Default
    @OneToMany(mappedBy = "owner")
    private List<PropertyBox> properties = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "card_kept_id")
    private Card cardKept;
}
