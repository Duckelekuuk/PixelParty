package com.duckelekuuk.cakewars.menus;

import com.duckelekuuk.cakewars.Cakewars;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

@Getter
public abstract class AbstractMenu implements InventoryHolder {

    private Cakewars plugin;
    protected Inventory inventory;

    public AbstractMenu(Cakewars plugin, String title, int size) {
        this.plugin = plugin;
        this.inventory = plugin.getServer().createInventory(null, size, title);
    }

    public void openInventory(Player player) {
        player.openInventory(inventory);
    }

    public abstract void onClick(Player player, ItemStack itemstack);

    @Override
    public Inventory getInventory() {
        return inventory;
    }
}
