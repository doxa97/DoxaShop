package fir.sec;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Gui implements Listener {

    public void BuyAndSellItem(String Display, Material material, int buy, int sell){
        ItemStack item = new ItemStack(material);
        ItemMeta item_Meta = item.getItemMeta();
        Objects.requireNonNull(item_Meta).setDisplayName(Display);
        item_Meta.setLore(Arrays.asList("[ "+material+" ]"));
        item.setItemMeta(item_Meta);

    }
}
