package com.pixelparty.api.games;

import com.pixelparty.api.inventory.AbstractGameInventory;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Collection;
import java.util.Collections;

public abstract class AbstractGame {

    private final boolean sharedScreen;
    private final Collection<Player> players;
    private AbstractGameInventory inventory;

    public AbstractGame(boolean sharedScreen, Collection<Player> players) {
        this.sharedScreen = sharedScreen;
        this.players = players;
    }

    public void onPlayerQuit(Player player) {
        players.remove(player);
    }

    public void setInventory(AbstractGameInventory inventory) {
        this.inventory = inventory;

        if (sharedScreen) {
            Inventory sharedInventory = inventory.getInventory();
            players.forEach(player -> player.openInventory(sharedInventory));
        } else players.forEach(player -> player.openInventory(inventory.getInventory()));
    }

    protected AbstractGameInventory getInventory() {
        return inventory;
    }

    protected Collection<Player> getPlayers() {
        return Collections.unmodifiableCollection(players);
    }
}
