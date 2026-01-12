package com.estanciero.api.models.entities;


import com.estanciero.api.models.enums.BotDifficultyType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Entity
@DiscriminatorValue("BOT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class Player_bot extends Player {

    @Enumerated(EnumType.STRING)
    private BotDifficultyType difficulty;


}
