package com.estanciero.api.models.entities;

import com.estanciero.api.models.entities.boxes.PropertyBox;
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

    private String color;

    private Double cash;

    private Integer position;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @OneToMany(mappedBy = "owner")
    private List<PropertyBox> properties;


}
