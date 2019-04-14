package com.pixelparty;

import com.pixelparty.api.IGameAPI;
import com.pixelparty.listeners.InventoryClickListener;
import com.pixelparty.listeners.InventoryCloseListener;
import com.pixelparty.listeners.InventoryDragListener;
import com.pixelparty.listeners.PlayerQuitListener;
import com.pixelparty.managers.SimpleGameApi;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class PixelParty extends JavaPlugin {

    private IGameAPI gameAPI;

    @Override
    public void onEnable() {
        gameAPI = new SimpleGameApi();
        registerListeners();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerListeners() {
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new InventoryClickListener(), this);
        pluginManager.registerEvents(new InventoryCloseListener(), this);
        pluginManager.registerEvents(new InventoryDragListener(), this);
        pluginManager.registerEvents(new InventoryDragListener(), this);
        pluginManager.registerEvents(new PlayerQuitListener(), this);
    }

    public IGameAPI getGameAPI() {
        return gameAPI;
    }
}
