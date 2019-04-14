package com.pixelparty.listeners;

import com.pixelparty.PixelParty;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerQuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        JavaPlugin.getPlugin(PixelParty.class).getGameAPI().
                getAllGameManagers().values().forEach(manager -> manager.onPlayerQuit(event.getPlayer()));
    }
}
