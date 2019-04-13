package com.duckelekuuk.cakewars.menus;

import com.duckelekuuk.cakewars.Cakewars;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Getter
public class MenuManager implements Listener {

    private Cakewars plugin;

    private Map<Object, AbstractMenu> menus;

    public MenuManager(Cakewars plugin) {
        this.plugin = plugin;

        this.menus = new HashMap<>();

        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public Collection<AbstractMenu> getMenus() {
        return menus.values();
    }

    public void registerMenu(Object key, AbstractMenu menu) {
        menus.put(key, menu);
    }

    @EventHandler
    public void onDrag(InventoryDragEvent event) {
        Inventory inventory = event.getWhoClicked().getOpenInventory().getTopInventory();

        getMenus()
                .stream()
                .filter(menu -> menu.getInventory().getName().equalsIgnoreCase(inventory.getName()))
                .findAny()
                .ifPresent(menu -> event.setCancelled(true));
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getWhoClicked();
        Inventory inventory = player.getOpenInventory().getTopInventory();

        getMenus()
                .stream()
                .filter(menu -> menu.getInventory().getName().equals(inventory.getName()))
                .forEach(menu -> menu.onClick(player, event.getCurrentItem()));
    }
}
