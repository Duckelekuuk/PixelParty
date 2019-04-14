package com.pixelparty.api.games;

import com.pixelparty.api.inventory.AbstractGameInventory;
import org.bukkit.entity.Player;

import java.util.Collection;

public abstract class AbstractTickingGame extends AbstractGame {

    public AbstractTickingGame(boolean sharedScreen, Collection<Player> players) {
        super(sharedScreen, players);
    }

    public abstract void onTick();
}
