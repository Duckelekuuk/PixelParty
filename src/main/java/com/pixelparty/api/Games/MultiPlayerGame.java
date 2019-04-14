package com.pixelparty.api.Games;

import org.bukkit.entity.Player;

import java.util.Collection;

public class MultiPlayerGame extends AbstractGame {

    public MultiPlayerGame(Collection<Player> players) {
        super(players);
    }
}
