package com.estanciero.api.models.entities;


import com.estanciero.api.models.enums.BotDifficultyType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("BOT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(onlyExplicitlyIncluded = true)
public class Player_bot extends Player {

    @Column(name = "bot_name")
    private String name;

    @Enumerated(EnumType.STRING)
    private BotDifficultyType difficulty;


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isUser(Long userId) {
        return false;
    }
}
