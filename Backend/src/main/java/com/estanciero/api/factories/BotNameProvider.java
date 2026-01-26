package com.estanciero.api.factories;

import com.estanciero.api.models.entities.Game;
import com.estanciero.api.models.entities.Player;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BotNameProvider {
    private static final List<String> NAMES_POOL = List.of("El_Capataz",
            "La_Yegua", "Pampero", "Gaucho_Gil", "Don_Segundo", "Martín_Fierro",
            "El_Hornero", "La_Vizcacha", "El_Comisario", "Doña_Petrona", "El_Pulpero",
            "Franco", "Pibe_Gamer", "C0rta_La_B8", "Zarpado_Bot", "Re_Picante", "Manso_Bot",
            "El_Mas_Capito", "Bot_Del_Ciber");

    private final Random random = new Random();


    public String getUniqueName(Game game) {
        //obtener los nombres en uso
        Set<String> usedNames = game.getPlayers().stream()
                .map(Player::getName).collect(Collectors.toSet());

        //filtrar el pool para obtener los que están disponibles
        List<String> availableNames = NAMES_POOL.stream()
                .filter(name -> !usedNames.contains(name))
                .toList();
        //si no hay nombres disponibles devuelve uno generico
        if (availableNames.isEmpty()) {
            return "Bot " + (game.getPlayers().size() + 1);
        }

        //devolver uno random de la pool
        return availableNames.get(random.nextInt(availableNames.size()));
    }
}
