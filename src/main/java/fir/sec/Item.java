package fir.sec;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class Item implements Listener {

    public void GuiItem(Player player) {

        Inventory Shop_Main = Bukkit.createInventory(null, 9, "[ Shop ]");


        Inventory Enchantment_Main = Bukkit.createInventory(null, 9, "[ Enchantment ]");


        Inventory Anvil_Main = Bukkit.createInventory(null, 9, "[ Anvil ]");

        //Gui.Normal("dsa",Material.ACACIA_BOAT,"fsa",4,Shop_Main);
        Gui.Normal("확인",Material.ACACIA_BOAT,"누르시면 다음으로 넘어갑니다.",4,Shop_Main);

    }
}









































