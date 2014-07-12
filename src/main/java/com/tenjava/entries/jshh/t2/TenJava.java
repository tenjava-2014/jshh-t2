package com.tenjava.entries.jshh.t2;

import com.tenjava.entries.jshh.t2.listeners.PlayerListener;
import com.tenjava.entries.jshh.t2.util.Log;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TenJava extends JavaPlugin {

    private static TenJava instance;

    @Override
    public void onEnable() {
        instance = this;
        Log.setDebugging(true);
        Log.log("Hello, World!");
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public void registerListeners() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerListener(this), this);
    }
    
    public static TenJava get() {
        return instance;
    }

}
