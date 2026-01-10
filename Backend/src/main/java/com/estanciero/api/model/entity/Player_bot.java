package com.estanciero.api.model.entity;


import com.estanciero.api.model.enums.BotDifficultyType;
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
@ToString(callSuper = true)
public class Player_bot extends Player {

    @Enumerated(EnumType.STRING)
    private BotDifficultyType difficulty;


}
