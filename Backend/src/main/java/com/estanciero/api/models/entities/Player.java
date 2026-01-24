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
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ColorType color;

    @Builder.Default
    private Double cash = 0.0;

    @Builder.Default
    private Integer position = 0;

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
