package com.pixelparty.api;

import com.pixelparty.api.games.AbstractGame;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface IGameManager {

    void registerGame(AbstractGame game);

    boolean startGame(int game, Set<Player> players);

    Map<Integer, AbstractGame> getAllRegisteredGames();
}
