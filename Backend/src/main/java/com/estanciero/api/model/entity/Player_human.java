package com.estanciero.api.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@DiscriminatorValue("HUMAN")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class Player_human extends Player {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
