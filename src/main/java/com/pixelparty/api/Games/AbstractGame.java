package com.pixelparty.api.Games;

import org.bukkit.entity.Player;

import java.util.Collection;

public abstract class AbstractGame {

    private Collection<Player> players;

    public AbstractGame(Collection<Player> players) {
        this.players = players;
    }
}
