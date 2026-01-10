package com.estanciero.api.model.entity;

import com.estanciero.api.model.entity.boxes.PropertyBox;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "players")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DiscriminatorColumn(name = "PLAYER_TYPE")
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
