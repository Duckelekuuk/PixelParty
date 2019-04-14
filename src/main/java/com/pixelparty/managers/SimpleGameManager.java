package com.pixelparty.managers;

import com.pixelparty.api.games.AbstractGame;
import com.pixelparty.api.IGameManager;
import org.bukkit.entity.Player;

import java.util.*;

public class SimpleGameManager implements IGameManager {

    private int registeredGamesCount = 0;
    private final Map<Integer, AbstractGame> registeredGames = new HashMap<>();

    @Override
    public void registerGame(AbstractGame game) {
        registeredGames.put(registeredGamesCount++, game);
    }

    @Override
    public boolean startGame(int game, Set<Player> players) {
        if (!registeredGames.containsKey(game)) return false;

        AbstractGame abstractGame = registeredGames.get(game);
        players.forEach(player -> player.openInventory(abstractGame.startNewGame(players).getInventory()));
        return true;
    }

    @Override
    public Map<Integer, AbstractGame> getAllRegisteredGames() {
        return Collections.unmodifiableMap(registeredGames);
    }
}
