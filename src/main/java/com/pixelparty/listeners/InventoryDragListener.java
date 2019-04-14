package com.pixelparty.listeners;

import com.pixelparty.api.inventory.AbstractInventory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

public class InventoryDragListener implements Listener {

    @EventHandler
    public void onClick(InventoryDragEvent event) {
        //Check if the clicked inventory is our inventory
        if (!(event.getInventory().getHolder() instanceof AbstractInventory)) return;

        //Make sure the entity who clicked is a player
        if ((event.getWhoClicked() instanceof Player)) return;

        //Cast to our inventory
        AbstractInventory abstractInventory = (AbstractInventory) event.getInventory().getHolder();

        //Call our method in the inventory to handle the inventory logic
        abstractInventory.onDrag(event);
    }
}
