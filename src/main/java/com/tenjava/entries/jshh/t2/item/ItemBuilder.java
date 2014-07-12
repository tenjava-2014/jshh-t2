package com.tenjava.entries.jshh.t2.item;

import com.tenjava.entries.jshh.t2.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {

    private Material material;
    private int amount;
    private final short data;
    private String displayName;
    private final List<String> lore = new ArrayList<>();
    private final HashMap<Enchantment, Integer> enchantments = new HashMap<>();

    public ItemBuilder(Material material) {
        this(material, 1);
    }

    public ItemBuilder(Material material, int amount) {
        this(material, amount, (short) 0);
    }

    public ItemBuilder(Material material, int amount, short data) {
        this.material = material;
        this.amount = amount;
        this.data = data;
    }

    public ItemBuilder setType(Material material) {
        this.material = material;
        return this;
    }

    public Material getType() {
        return material;
    }

    public ItemBuilder setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public ItemBuilder setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public String getDisplayName() {
        return displayName;
    }

    public ItemBuilder addLores(List<String> lores) {
        this.lore.addAll(lores);
        return this;
    }

    public List<String> getLores() {
        return lore;
    }

    public ItemBuilder addLore(String lore) {
        this.lore.add(lore);
        return this;
    }

    public ItemBuilder addEnchantment(Enchantment enchant, int level) {
        if (enchantments.containsKey(enchant)) {
            enchantments.remove(enchant);
        }
        enchantments.put(enchant, level);
        return this;
    }

    public HashMap<Enchantment, Integer> getEnchantments() {
        return enchantments;
    }

    public ItemStack build() {
        Material material = this.material;
        if (material == null) {
            material = Material.STICK;
            Log.warning("ItemBuilder -- Invalid material specified");
        }
        ItemStack item = new ItemStack(this.material, this.amount, this.data);
        ItemMeta meta = item.getItemMeta();
        if (this.displayName != null) {
            meta.setDisplayName(this.displayName);
        }
        if (!this.lore.isEmpty()) {
            meta.setLore(this.lore);
        }
        item.setItemMeta(meta);
        item.addUnsafeEnchantments(enchantments);
        return item;
    }

}
