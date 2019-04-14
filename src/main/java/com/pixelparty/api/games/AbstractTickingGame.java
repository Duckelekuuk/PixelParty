package com.pixelparty.api.games;

import com.pixelparty.api.inventory.AbstractGameInventory;
import org.bukkit.entity.Player;

import java.util.Collection;

public abstract class AbstractTickingGame extends AbstractGame {

    public AbstractTickingGame(AbstractGameInventory inventory, boolean shareScreen, Collection<Player> players) {
        super(inventory, shareScreen, players);
    }

    public abstract void onTick();
}
