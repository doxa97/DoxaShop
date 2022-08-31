package fir.sec;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Objects;

public class Death implements Listener {

    public void PlayerDeathEvent (PlayerDeathEvent event) {
        Player player = event.getEntity();
        long[] money = Money.getMoney(player.getUniqueId().toString());
        Location location = event.getEntity().getLocation();
        World world = player.getWorld();
        if (!(money == null)) {
            money[5] = money[6] / 10L;
            ItemStack paper = new ItemStack(Material.PAPER);
            ItemMeta im = paper.getItemMeta();
            assert im != null;
            im.setDisplayName(ChatColor.DARK_AQUA + "[ DOXSHOP ] " + ChatColor.WHITE + money[5]+ " 에르");
            im.setLore(Arrays.asList(ChatColor.GRAY+"전 지역에서 활발하게 사용되는 화폐이다.",ChatColor.GRAY+"재질은 아르킨 제국의 하프의 털로 만들어져 부드럽다."));
            im.setCustomModelData(1);
            paper.setItemMeta(im);
            world.dropItemNaturally(location, paper);
            for (int i = 0; i < player.getInventory().getSize(); i++) {
                String item = Objects.requireNonNull(Objects.requireNonNull(player.getInventory().getItem(i)).getItemMeta()).getDisplayName();
                if (item.contains("에르")){
                    if (item.contains("[ DOXSHOP ]")){
                        if (event.getKeepInventory()) {
                            ItemStack er = player.getInventory().getItem(i);
                            for (int o = 0; o < Objects.requireNonNull(er).getAmount() ; i++){
                                Objects.requireNonNull(er).setType(Material.AIR);
                                world.dropItemNaturally(location, er);
                            }
                        }
                    }

                }
            }
        }
    }

}
