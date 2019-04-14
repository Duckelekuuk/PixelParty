package com.pixelparty.api;

import com.pixelparty.api.games.AbstractGameManager;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.Map;

public interface IGameAPI {

    void registerGameManager(AbstractGameManager gameManager);

    boolean startNewGame(Class<? extends AbstractGameManager> gameManagerClass, Collection<Player> players);

    Map<Class<? extends AbstractGameManager>, AbstractGameManager> getAllGameManagers();
}
