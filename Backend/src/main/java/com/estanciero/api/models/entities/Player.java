package com.estanciero.api.models.entities;

import com.estanciero.api.models.entities.boxes.PropertyBox;
import com.estanciero.api.models.enums.ColorType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "players")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DiscriminatorColumn(name = "PLAYER_TYPE", discriminatorType = DiscriminatorType.STRING)
@ToString(onlyExplicitlyIncluded = true)
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ColorType color;

    private Double cash = 0.0;

    private Integer position = 0;

    @ManyToOne
    @JoinColumn(name = "game_id")
    @JsonIgnore
    private Game game;

    @OneToMany(mappedBy = "owner")
    private List<PropertyBox> properties;

    @OneToOne
    @JoinColumn(name = "card_kept_id")
    private Card cardKept;
}
