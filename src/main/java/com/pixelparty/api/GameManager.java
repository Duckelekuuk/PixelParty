package com.pixelparty.api;

import com.pixelparty.api.Games.AbstractGame;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

public final class GameManager {

    private static GameManager instance = new GameManager();

    private Collection<AbstractGame> runningGames;

    public static GameManager getInstance() {
        return instance;
    }

    public <T extends AbstractGame> T StartMupliplayerGame(Class<T> game, Player... players) {
        try {
            AbstractGame gameInstance = game.getDeclaredConstructor(game).newInstance(players);
            runningGames.add(gameInstance);

            return game.cast(gameInstance);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }
}
