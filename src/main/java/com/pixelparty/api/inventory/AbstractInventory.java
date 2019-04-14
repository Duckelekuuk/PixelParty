package com.pixelparty.api.inventory;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public abstract class AbstractInventory implements InventoryHolder {

    private final Inventory inventory;

    public AbstractInventory() {
        this.inventory = Bukkit.createInventory(this, 54);
    }

    public AbstractInventory(int size) {
        this.inventory = Bukkit.createInventory(this, size);
    }

    public AbstractInventory(int size, String title) {
        this.inventory = Bukkit.createInventory(this, size, title);
    }

    public AbstractInventory(InventoryType inventoryType) {
        this.inventory = Bukkit.createInventory(this, inventoryType);
    }

    public AbstractInventory(InventoryType inventoryType, String title) {
        this.inventory = Bukkit.createInventory(this, inventoryType, title);
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    public void onDrag(InventoryDragEvent event) {}
    public void onClick(InventoryClickEvent event) {}
    public void onOpen(InventoryOpenEvent event) {}
    public void onClose(InventoryCloseEvent event) {}
}
