package com.estanciero.api.dtos.game;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record JoinGameDto(
        @NotNull(message = "The user ID is required.")
        @Positive(message = "The user ID must be positive")
        Long userId
) {
}
