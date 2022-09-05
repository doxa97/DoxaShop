package fir.sec;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Gui implements Listener{

    public static void BuyAndSellItem(String Display, Material material, String buy, String sell, int loc, Inventory inv){
        ItemStack item = new ItemStack(material);
        ItemMeta item_Meta = item.getItemMeta();
        Objects.requireNonNull(item_Meta).setDisplayName(Display);
        item_Meta.setLore(Arrays.asList("[ "+material+" ]","\r\n","\r\n","\r\n","판매 금액 : "+sell,"\r\n"+"구매 금액 : "+buy,"\r\n","쉬프트 키를 누르시면 64개 교환이 됩니다."));
        item.setItemMeta(item_Meta);
        inv.setItem(loc, item);
    }

    public static void SpawnItem(String Display, String buy, String lore, int loc, Inventory inv) {
        ItemStack item = new ItemStack(Material.VILLAGER_SPAWN_EGG);
        ItemMeta item_Meta = item.getItemMeta();
        Objects.requireNonNull(item_Meta).setDisplayName(Display);
        item_Meta.setLore(Arrays.asList("[ " + Display + " 소환권 ]","\r\n",lore,"\r\n","고용 비용 : "+buy));
        item.setItemMeta(item_Meta);
        inv.setItem(loc, item);
    }

    public static void Recipe(String Display, Material material, String buy, String lore, int loc, Inventory inv) {
        ItemStack item = new ItemStack(material);
        ItemMeta item_Meta = item.getItemMeta();
        Objects.requireNonNull(item_Meta).setDisplayName(Display);
        item_Meta.setLore(Arrays.asList("[ " + material + " 조합법 ]","\r\n",lore,"\r\n","학습 비용 : "+buy));
        item.setItemMeta(item_Meta);
        inv.setItem(loc, item);
    }

    public static void Normal(String Display, Material material, String lore, int loc, Inventory inv) {
        ItemStack item = new ItemStack(material);
        ItemMeta item_Meta = item.getItemMeta();
        Objects.requireNonNull(item_Meta).setDisplayName(Display);
        item_Meta.setLore(Collections.singletonList(lore));
        item.setItemMeta(item_Meta);
        inv.setItem(loc, item);
    }


}


























