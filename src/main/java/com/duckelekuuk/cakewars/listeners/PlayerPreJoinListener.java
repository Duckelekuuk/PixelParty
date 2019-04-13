package com.duckelekuuk.cakewars.listeners;

import com.duckelekuuk.cakewars.Cakewars;
import com.duckelekuuk.cakewars.match.GamePlayer;
import lombok.Getter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPreLoginEvent;

public class PlayerPreJoinListener implements Listener {

    @Getter
    private Cakewars plugin;

    public PlayerPreJoinListener(Cakewars plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onJoin(AsyncPlayerPreLoginEvent event) {
        if (!plugin.getConfigHandler().getGlobal().isReadyToPlay()) {
            return;
        }

        if (!plugin.getGameManager().getActiveMatch().isLoaded()) {
            event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, "Game is getting ready!");
        }
    }
}
