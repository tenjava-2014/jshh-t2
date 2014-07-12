package com.tenjava.entries.jshh.t2.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerListener implements Listener {

    private static JavaPlugin plugin;

    public PlayerListener(JavaPlugin plugin) {
        PlayerListener.plugin = plugin;
    }
    
    @EventHandler
    public void onJoin(PlayerJoinEvent ev) {
        ev.getPlayer().sendMessage("Make sure you come back again!"); // Replay level increased by 500%!
    }

}
