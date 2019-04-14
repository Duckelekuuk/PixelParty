package com.pixelparty.managers;

import com.pixelparty.api.IGameManager;
import com.pixelparty.api.games.AbstractGameInfo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SimpleGameManager implements IGameManager {

    private final Map<Class<? extends AbstractGameInfo>, AbstractGameInfo> registeredGames = new HashMap<>();

    @Override
    public void registerGame(AbstractGameInfo game) {
        registeredGames.put(game.getClass(), game);
    }

    @Override
    public Collection<AbstractGameInfo> getAllRegisteredGames() {
        return registeredGames.values();
    }

    @Override
    public <T extends AbstractGameInfo> T getGame(Class<T> gameInfoClass) {
        if (registeredGames.containsKey(gameInfoClass)) return null;
        return gameInfoClass.cast(registeredGames.get(gameInfoClass));
    }
}
