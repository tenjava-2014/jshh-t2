package com.tenjava.entries.jshh.t2.item;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class IronPickaxeTwo extends ItemStack {
    
    private static List<String> lores = new ArrayList<>();
    
    public IronPickaxeTwo() {
        super(Material.IRON_PICKAXE, 1);
        ItemMeta meta = getItemMeta();
        
        meta.setDisplayName(ChatColor.GRAY + "Iron Pickaxe II");
        meta.setLore(new ArrayList<String>(){{
            add("A stronger pickaxe for those who");
            add("cannot afford a diamond pickaxe.");
        }});
        
        setItemMeta(meta);
        setDurability((short) 500); // Won't fucking work :(
    }
    
}
