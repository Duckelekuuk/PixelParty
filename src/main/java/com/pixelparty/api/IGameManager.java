package com.pixelparty.api;

import com.pixelparty.api.Games.AbstractGame;

import java.util.Collection;

public interface IGameManager {

    /**
     * Returns a list of the games currently active
     * @return Collection of the running games
     */
    Collection<AbstractGame> getRunningGames();

    void registerGame(AbstractGame game);

}
