package fir.sec;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class Join implements Listener {

    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        long[] money = Money.getMoney(player.getUniqueId().toString());
        if (money == null){
            Money.CreateMoney(player.getUniqueId().toString());
            e.setJoinMessage("첫 접속을 환영합니다. "+player.getName()+ "사축님.");
            player.performCommand("recipe give "+player.getName()+" *");

            ItemStack i = new ItemStack(Material.LEATHER_CHESTPLATE);

            player.performCommand("recipe take "+player.getName()+" crafting_table");
            player.performCommand("recipe take "+player.getName()+" furnace");
            player.performCommand("recipe take "+player.getName()+" stick");
            player.performCommand("recipe take "+player.getName()+" book");
            player.performCommand("recipe take "+player.getName()+" bow");
            player.performCommand("recipe take "+player.getName()+" arrow");
            player.performCommand("recipe take "+player.getName()+" tnt");
            player.performCommand("recipe take "+player.getName()+" chest");
            player.performCommand("recipe take "+player.getName()+" enchanting_table");
            player.performCommand("recipe take "+player.getName()+" ender_chest");
            player.performCommand("recipe take "+player.getName()+" anvil");
            player.performCommand("recipe take "+player.getName()+" shulker_box");
            player.performCommand("recipe take "+player.getName()+" piston");
            player.performCommand("recipe take "+player.getName()+" dispenser");
            player.performCommand("recipe take "+player.getName()+" dropper");
            player.performCommand("recipe take "+player.getName()+" repeater");
            player.performCommand("recipe take "+player.getName()+" comparator");
            player.performCommand("recipe take "+player.getName()+" beacon");
            player.performCommand("recipe take "+player.getName()+" ender_eye");
            player.performCommand("recipe take "+player.getName()+" end_crystal");
            player.performCommand("recipe take "+player.getName()+" shield");
            player.performCommand("recipe take "+player.getName()+" shears");

            player.performCommand("recipe take "+player.getName()+" leather_helmet");
            player.performCommand("recipe take "+player.getName()+" leather_chestplate");
            player.performCommand("recipe take "+player.getName()+" leather_leggings");
            player.performCommand("recipe take "+player.getName()+" leather_boots");

            player.performCommand("recipe take "+player.getName()+" golden_helmet");
            player.performCommand("recipe take "+player.getName()+" golden_chestplate");
            player.performCommand("recipe take "+player.getName()+" golden_leggings");
            player.performCommand("recipe take "+player.getName()+" golden_boots");

            player.performCommand("recipe take "+player.getName()+" iron_helmet");
            player.performCommand("recipe take "+player.getName()+" iron_chestplate");
            player.performCommand("recipe take "+player.getName()+" iron_leggings");
            player.performCommand("recipe take "+player.getName()+" iron_boots");

            player.performCommand("recipe take "+player.getName()+" diamond_helmet");
            player.performCommand("recipe take "+player.getName()+" diamond_chestplate");
            player.performCommand("recipe take "+player.getName()+" diamond_leggings");
            player.performCommand("recipe take "+player.getName()+" diamond_boots");

            player.performCommand("recipe take "+player.getName()+" wooden_pickaxe");
            player.performCommand("recipe take "+player.getName()+" wooden_axe");
            player.performCommand("recipe take "+player.getName()+" wooden_shovel");
            player.performCommand("recipe take "+player.getName()+" wooden_hoe");
            player.performCommand("recipe take "+player.getName()+" wooden_sword");

            player.performCommand("recipe take "+player.getName()+" stone_pickaxe");
            player.performCommand("recipe take "+player.getName()+" stone_axe");
            player.performCommand("recipe take "+player.getName()+" stone_shovel");
            player.performCommand("recipe take "+player.getName()+" stone_hoe");
            player.performCommand("recipe take "+player.getName()+" stone_sword");

            player.performCommand("recipe take "+player.getName()+" iron_pickaxe");
            player.performCommand("recipe take "+player.getName()+" iron_axe");
            player.performCommand("recipe take "+player.getName()+" iron_shovel");
            player.performCommand("recipe take "+player.getName()+" iron_hoe");
            player.performCommand("recipe take "+player.getName()+" iron_sword");

            player.performCommand("recipe take "+player.getName()+" golden_pickaxe");
            player.performCommand("recipe take "+player.getName()+" golden_axe");
            player.performCommand("recipe take "+player.getName()+" golden_shovel");
            player.performCommand("recipe take "+player.getName()+" golden_hoe");
            player.performCommand("recipe take "+player.getName()+" golden_sword");

            player.performCommand("recipe take "+player.getName()+" diamond_pickaxe");
            player.performCommand("recipe take "+player.getName()+" diamond_axe");
            player.performCommand("recipe take "+player.getName()+" diamond_shovel");
            player.performCommand("recipe take "+player.getName()+" diamond_hoe");
            player.performCommand("recipe take "+player.getName()+" diamond_sword");

        }
        else {
            e.setJoinMessage("환영합니다! "+player.getName()+ "주민님!");
        }
    }

}
