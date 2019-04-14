package com.pixelparty.listeners;

import com.pixelparty.api.inventory.AbstractInventory;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        //Check if the clicked inventory is our inventory
        if (!(event.getInventory().getHolder() instanceof AbstractInventory)) return;

        //Make sure he clicked on the inventory
        if (event.getClickedInventory() == null) return;

        //Cast to our inventory
        AbstractInventory abstractInventory = (AbstractInventory) event.getInventory().getHolder();

        //Call our method in the inventory to handle the inventory logic
        abstractInventory.onClick(event);
    }
}
