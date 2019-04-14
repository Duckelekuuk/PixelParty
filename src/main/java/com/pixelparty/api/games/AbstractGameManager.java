package com.pixelparty.api.games;

import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public abstract class AbstractGameManager<G extends AbstractGame, I extends AbstractGameInfo> {

    @Getter
    private final I gameInfo;
    private final Collection<G> activeGames = new HashSet<>();

    public AbstractGameManager(I gameInfo) {
        this.gameInfo = gameInfo;
    }

    public void startNewGame(Collection<Player> players) {
        activeGames.add(getNewGame(players));
    }

    public void onPlayerQuit(Player player) {

    }

    protected abstract G getNewGame(Collection<Player> players);

    protected Collection<G> getActiveGames() {
        return Collections.unmodifiableCollection(activeGames);
    }

    protected int getActiveGamesSize() {
        return activeGames.size();
    }
}
