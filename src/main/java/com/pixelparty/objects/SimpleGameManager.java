package com.pixelparty.objects;

import com.pixelparty.api.Games.AbstractGame;
import com.pixelparty.api.IGameManager;

import java.util.Collection;
import java.util.HashSet;

public class SimpleGameManager implements IGameManager {

    private Collection<AbstractGame> runningGames = new HashSet<>();

    @Override
    public Collection<AbstractGame> getRunningGames() {
        return runningGames;
    }

    @Override
    public void registerGame(AbstractGame game) {
        runningGames.add(game);
    }
}
