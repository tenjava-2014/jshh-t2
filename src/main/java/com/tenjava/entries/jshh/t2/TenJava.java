package com.tenjava.entries.jshh.t2;

import com.tenjava.entries.jshh.t2.item.IronPickaxeTwo;
import com.tenjava.entries.jshh.t2.listeners.PlayerListener;
import com.tenjava.entries.jshh.t2.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TenJava extends JavaPlugin {

    private static TenJava instance;
    @Override
    public void onEnable() {
        // TODO: Cry about my lack of creativity </3
        instance = this;
        
        registerListeners();
        setupRecipes();
        
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
    
    private void setupRecipes() {
        List<ShapelessRecipe> shapeless = new ArrayList<>();
        
        ShapelessRecipe pickaxeTwo = new ShapelessRecipe(new IronPickaxeTwo())
                .addIngredient(1, Material.IRON_PICKAXE)
                .addIngredient(3, Material.IRON_INGOT);
        
        shapeless.add(pickaxeTwo);
        
        for(ShapelessRecipe r : shapeless) {
            getServer().addRecipe(r);
        }
    }

    public static TenJava get() {
        return instance;
    }

}
