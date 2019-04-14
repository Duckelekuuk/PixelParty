package com.pixelparty.api.Games;

import com.pixelparty.api.inventory.AbstractInventory;
import org.bukkit.entity.Player;

import java.util.Collection;

public abstract class AbstractGame {

    private final AbstractInventory mainInventory;
    private Collection<Player> players;

    public AbstractGame(Collection<Player> players) {
        this.players = players;
        mainInventory = null;
    }

    public void start(){}
}
