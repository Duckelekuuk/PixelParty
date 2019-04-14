package com.pixelparty.api;

import com.pixelparty.api.Games.AbstractGame;

import java.util.Collection;

public final class GameManager {

    private static GameManager instance = new GameManager();

    private Collection<AbstractGame> runningGames;

    public static GameManager getInstance() {
        return instance;
    }
}
