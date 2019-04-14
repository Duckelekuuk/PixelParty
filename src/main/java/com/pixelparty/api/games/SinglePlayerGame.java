package com.pixelparty.api.games;

import org.bukkit.entity.Player;

import java.util.Collection;

public class SinglePlayerGame extends AbstractGame {

    public SinglePlayerGame(Collection<Player> players) {
        super(players);
    }
}
