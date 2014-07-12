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
        registerListeners();

        Log.setDebugging(true);
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    private void registerListeners() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerListener(this), this);
    }

    public static TenJava get() {
        return instance;
    }

}
