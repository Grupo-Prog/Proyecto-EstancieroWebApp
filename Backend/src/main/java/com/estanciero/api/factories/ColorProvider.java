package com.estanciero.api.factories;

import com.estanciero.api.models.entities.Game;
import com.estanciero.api.models.entities.Player;
import com.estanciero.api.models.enums.ColorType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ColorProvider {


    public List<ColorType> getAvailableColors(Game game) {
        //creo una lista con todos los colores del enum
        List<ColorType> availableColors = new ArrayList<>(Arrays.asList(ColorType.values()));

        //recorre todos los jugadores: si el player ya tiene un color elimina ese color de la lista
        for (Player p : game.getPlayers()) {
            if (p.getColor() != null) {
                availableColors.remove(p.getColor());
            }
        }

        //devuelvo los colores no usados
        return availableColors;
    }

    public void assignColorToPlayer(Long playerId, ColorType color, Game game) {
        //obtengo los colores que todavia no estan usados en el game
        List<ColorType> availableColors = this.getAvailableColors(game);

        //verifico que el color elegido no haya sido tomado
        if (!availableColors.contains(color)) {
            throw new IllegalStateException("this color is already taken");
        }

        //busco al player por id, si no lo encuentra en el game tira una excepcion
        Player player = game.findPlayerOrThrow(playerId);

        //asigno el color al player
        player.setColor(color);
    }


    public void assignRandomColors(Game game) {
        //obtengo la lista de colores desde getAvailableColors() y los copio a una nueva lista
        List<ColorType> availableColors = new ArrayList<>(getAvailableColors(game));

        //mezclo la lista aleatoriamente
        Collections.shuffle(availableColors);

        //recorre todos los players: asigno el primer color disponible y lo elimino para no repetirlo
        for (Player player : game.getPlayers()) {
            if (player.getColor() == null) {
                if (availableColors.isEmpty()) {
                    throw new IllegalStateException("No available colors left");
                }
                player.setColor(availableColors.remove(0));
            }
        }
    }
}
