package com.pixelparty.api;

import com.pixelparty.api.games.AbstractGameInfo;

import java.util.Collection;
import java.util.Map;

public interface IGameManager {

    void registerGame(AbstractGameInfo game);

    Collection<AbstractGameInfo> getAllRegisteredGames();

    <T extends AbstractGameInfo> T getGame(Class<T> gameInfoClass);
}
