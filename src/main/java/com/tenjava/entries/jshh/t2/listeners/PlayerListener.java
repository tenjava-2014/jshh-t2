package com.tenjava.entries.jshh.t2.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerListener {

    private static JavaPlugin plugin;
    
    public PlayerListener(JavaPlugin plugin) {
        PlayerListener.plugin = plugin;
    }
    
    @EventHandler
    public void onJoin(PlayerJoinEvent ev) {
        /* Do shit */
    }
    
}
