package com.pixelparty.api.inventory;

import com.pixelparty.api.games.AbstractGame;
import org.bukkit.event.inventory.*;

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

    @Override
    public void onDrag(InventoryDragEvent event) {
        abstractGame.onDrag(event);
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        abstractGame.onClick(event);
    }

    @Override
    public void onOpen(InventoryOpenEvent event) {
        abstractGame.onOpen(event);
    }

    @Override
    public void onClose(InventoryCloseEvent event) {
        abstractGame.onClose(event);
    }
}
