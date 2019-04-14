package com.pixelparty.api.games;

import com.pixelparty.api.inventory.AbstractGameInventory;
import com.pixelparty.api.inventory.AbstractInventory;
import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.Collection;

public abstract class AbstractGame<T extends AbstractGameInfo> {

    @Getter
    private final T gameInfo;

    private AbstractGameInventory mainInventory;

    public AbstractGame(T gameInfo) {
        this.gameInfo = gameInfo;
    }

    public abstract AbstractInventory startNewGame(Collection<Player> playersWhichPlay);
}
