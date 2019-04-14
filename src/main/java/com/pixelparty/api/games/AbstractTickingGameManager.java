package com.pixelparty.api.games;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public abstract class AbstractTickingGameManager<G extends AbstractTickingGame, I extends AbstractGameInfo> extends AbstractGameManager<G, I> {

    public AbstractTickingGameManager(I gameInfo, Plugin plugin, long firstDelay, long tickSpeed) {
        super(gameInfo);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> activeGames.forEach(AbstractTickingGame::onTick), firstDelay, tickSpeed);
    }
}
