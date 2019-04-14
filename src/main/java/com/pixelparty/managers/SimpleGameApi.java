package com.pixelparty.managers;

import com.pixelparty.api.IGameAPI;
import com.pixelparty.api.games.AbstractGameManager;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SimpleGameApi implements IGameAPI {

    private final Map<Class<? extends AbstractGameManager>, AbstractGameManager> gameManagerMap = new HashMap<>();

    @Override
    public void registerGameManager(AbstractGameManager gameManager) {
        gameManagerMap.put(gameManager.getClass(), gameManager);
    }

    @Override
    public boolean startNewGame(Class<? extends AbstractGameManager> gameManagerClass, Collection<Player> players) {
        if (!gameManagerMap.containsKey(gameManagerClass)) return false;

        AbstractGameManager manager = gameManagerMap.get(gameManagerClass);
        manager.startNewGame(players);
        return true;
    }

    @Override
    public Map<Class<? extends AbstractGameManager>, AbstractGameManager> getAllGameManagers() {
        return Collections.unmodifiableMap(gameManagerMap);
    }
}
