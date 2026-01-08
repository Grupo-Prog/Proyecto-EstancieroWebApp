package com.estanciero.api.domain.entities;

import com.estanciero.api.domain.entities.boxes.PropertyBox;
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
@ToString(onlyExplicitlyIncluded = true)
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String color;

    private Double cash;

    private Integer position;

    @OneToMany(mappedBy = "owner")
    private List<PropertyBox> properties;

}
