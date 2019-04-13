package com.duckelekuuk.cakewars.listeners;

import com.duckelekuuk.cakewars.Cakewars;
import com.duckelekuuk.cakewars.match.GamePlayer;
import lombok.Getter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @Getter
    private Cakewars plugin;

    public PlayerJoinListener(Cakewars plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (!plugin.getConfigHandler().getGlobal().isReadyToPlay()) {
            return;
        }

        GamePlayer gamePlayer = plugin.getGameManager().getGameplayer(event.getPlayer(), true);

        switch (plugin.getGameManager().getActiveMatch().getMatchStatus()) {
            case LOBBY:
                event.getPlayer().teleport(plugin.getGameManager().getActiveMatch().getMapConfig().getLocations().getLobbyLocation());
                break;

            case COUNTDOWN:
                event.getPlayer().teleport(plugin.getGameManager().getActiveMatch().getMapConfig().getLocations().getLobbyLocation());
                break;


            case INGAME:
            case END:
                event.getPlayer().teleport(plugin.getGameManager().getActiveMatch().getMapConfig().getLocations().getSpawnSpectator());
                gamePlayer.makeSpectator();
                break;
        }
    }
}
