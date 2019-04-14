package com.pixelparty.api.inventory;

import com.pixelparty.api.games.AbstractGame;
import org.bukkit.event.inventory.InventoryType;

public abstract class AbstractGameInventory<T extends AbstractGame> extends AbstractInventory {

    private final T abstractGame;

    public AbstractGameInventory(T abstractGame, int size) {
        super(size);
        this.abstractGame = abstractGame;
    }

    public AbstractGameInventory(T abstractGame, int size, String title) {
        super(size, title);
        this.abstractGame = abstractGame;
    }

    public AbstractGameInventory(T abstractGame, InventoryType inventoryType) {
        super(inventoryType);
        this.abstractGame = abstractGame;
    }

    public AbstractGameInventory(T abstractGame, InventoryType inventoryType, String title) {
        super(inventoryType, title);
        this.abstractGame = abstractGame;
    }
}
