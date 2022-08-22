package fir.sec;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Objects;

public class Interact implements Listener {

    @EventHandler
    public void RightClick(PlayerInteractEvent e){
        Player p = e.getPlayer();
        Action a = e.getAction();
        if(a == Action.RIGHT_CLICK_AIR){
            if (Objects.requireNonNull(p.getEquipment()).getItemInMainHand().getType() == Material.PAPER){
                ItemStack total = p.getEquipment().getItemInMainHand();
                ItemMeta paper = total.getItemMeta();
                if (Objects.requireNonNull(paper).getDisplayName().contains("골드")) {
                    paper.setDisplayName(paper.getDisplayName().replace("[ DOXSHOP ] ", "").replace(" 골드", ""));
                    int money = Integer.parseInt(ChatColor.stripColor(paper.getDisplayName()));
                    long[] stat;
                    stat = Money.getMoney(p.getUniqueId().toString());
                    stat[4] = money;
                    Money.setMoney(p.getUniqueId().toString(), stat);
                    ItemStack is = p.getInventory().getItemInMainHand();
                    ItemStack air = new ItemStack(Material.AIR);
                    if (is.getAmount() > 1){
                        is.setAmount(is.getAmount()-1);
                    }else {
                        p.getEquipment().setItemInMainHand(air);
                    }
                    p.getInventory().setItemInHand(is);
                    p.updateInventory();
                }
            }
        }
    }

    @EventHandler
    public void ChestClick(InventoryClickEvent event) {
        if (event.getView().getTitle().contains("상점")) {

            Player player = (Player) event.getWhoClicked();
            long[] money= Money.getMoney(player.getUniqueId().toString());
            ArrayList<String> ClickItem = (ArrayList<String>) Objects.requireNonNull(Objects.requireNonNull(event.getCurrentItem()).getItemMeta()).getLore();
            if (Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(event.getCurrentItem()).getItemMeta()).getLore()).contains("[ 상점 물품 ]")){
                for (int i = 0; i < Objects.requireNonNull(ClickItem).size(); i++) {
                    if (event.isShiftClick()){
                        if (event.isLeftClick()){
                            if (ClickItem.get(i).contains("판매 금액 : ")){
                                int Money = Integer.parseInt(ClickItem.get(i).replace("판매 금액 : ","").replace(",",""));

                                player.sendMessage(ChatColor.DARK_AQUA + "[ DOXSHOP ]" + ChatColor.WHITE + "판매에 성공하였습니다.");
                                money[4] = 64L * Money;
                            }
                        }
                        else if (event.isRightClick()){
                            if (ClickItem.get(i).contains("구매 금액 : ")){
                                int Money = Integer.parseInt(ClickItem.get(i).replace("구매 금액 : ","").replace(",",""));

                                player.sendMessage(ChatColor.DARK_AQUA + "[ DOXSHOP ]" + ChatColor.WHITE + "구매에 성공하였습니다.");
                                money[5] = 64L * Money;
                            }
                        }
                    }
                    else if (!(event.isShiftClick())){
                        if (event.isLeftClick()){
                            if (ClickItem.get(i).contains("판매 금액 : ")){
                                int Money = Integer.parseInt(ClickItem.get(i).replace("판매 금액 : ","").replace(",",""));

                                player.sendMessage(ChatColor.DARK_AQUA + "[ DOXSHOP ]" + ChatColor.WHITE + "판매에 성공하였습니다.");
                                money[4] = Money;
                            }
                        }
                        else if (event.isRightClick()){
                            if (ClickItem.get(i).contains("구매 금액 : ")){
                                int Money = Integer.parseInt(ClickItem.get(i).replace("구매 금액 : ","").replace(",",""));

                                player.sendMessage(ChatColor.DARK_AQUA + "[ DOXSHOP ]" + ChatColor.WHITE + "구매에 성공하였습니다.");
                                money[5] = Money;
                            }
                        }
                    }
                }
            }
        }
    }

}






























