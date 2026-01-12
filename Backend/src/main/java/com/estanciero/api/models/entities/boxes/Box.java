package com.estanciero.api.models.entities.boxes;

import com.estanciero.api.models.entities.Board;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "boxes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "box_type", discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public abstract class Box {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer position;
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    //METODO PARA IMPLEMENTAR ?
    // public abstract void handlePlayerLand(Player player);
}
