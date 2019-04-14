package com.pixelparty.api.games;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.Collection;

public abstract class AbstractTickingGameManager<G extends AbstractTickingGame, I extends AbstractGameInfo> extends AbstractGameManager<G, I> {

    private int taskId = -1;
    private final Plugin plugin;
    private final long firstDelay, tickSpeed;

    public AbstractTickingGameManager(I gameInfo, Plugin plugin, long firstDelay, long tickSpeed) {
        super(gameInfo);
        this.plugin = plugin;
        this.firstDelay = firstDelay;
        this.tickSpeed = tickSpeed;
    }

    @Override
    public void startNewGame(Collection<Player> players) {
        super.startNewGame(players);
        checkIfTaskShouldRunOrBeDisabled();
    }

    @Override
    public void onPlayerQuit(Player player) {
        super.onPlayerQuit(player);
        checkIfTaskShouldRunOrBeDisabled();
    }

    private void checkIfTaskShouldRunOrBeDisabled() {
        if (taskId == -1 && getActiveGamesSize() > 0) {
            taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> getActiveGames().forEach(AbstractTickingGame::onTick), firstDelay, tickSpeed);
        } else if (taskId != -1 && getActiveGamesSize() == 0) {
            Bukkit.getScheduler().cancelTask(taskId);
        }
    }
}
