package com.pixelparty.api.games;

import com.pixelparty.api.inventory.AbstractGameInventory;
import org.bukkit.entity.Player;

import java.util.Collection;

public abstract class AbstractGame {

    private AbstractGameInventory inventory;
    private final boolean shareScreen;
    protected final Collection<Player> players;

    public AbstractGame(AbstractGameInventory inventory, boolean shareScreen, Collection<Player> players) {
        setInventory(inventory);
        this.shareScreen = shareScreen;
        this.players = players;
    }

    public void onPlayerQuit(Player player) {
        players.remove(player);
    }

    protected void setInventory(AbstractGameInventory inventory) {
        this.inventory = inventory;
    }
}
