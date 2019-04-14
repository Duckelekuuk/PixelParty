package com.pixelparty.api;

import com.pixelparty.api.games.AbstractGameManager;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.Set;

public interface IGameAPI {

    void registerGameManager(AbstractGameManager gameManager);

    boolean startNewGame(Class<? extends AbstractGameManager> gameManagerClass, Set<Player> players);

    Map<Class<? extends AbstractGameManager>, AbstractGameManager> getAllGameManagers();
}
