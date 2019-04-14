package com.pixelparty.api.games;

import com.pixelparty.api.inventory.AbstractInventory;
import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.Collection;

public abstract class AbstractGame {

    @Getter
    private final String prettyName, description;

    public AbstractGame(String prettyName, String description) {
        this.prettyName = prettyName;
        this.description = description;
    }

    public abstract AbstractInventory startNewGame(Collection<Player> playersWhichPlay);
}
