package fir.sec;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
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
                if (Objects.requireNonNull(paper).getDisplayName().contains("에르")) {
                    paper.setDisplayName(paper.getDisplayName().replace("[ DOXSHOP ] ", "").replace(" 에르", ""));
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
                        if (ClickItem.get(i).contains("판매 금액 : ")){
                            int Money = Integer.parseInt(ClickItem.get(i).replace("판매 금액 : ","").replace(",","")) * 64;
                            if  (Money >= money[6]){
                                player.sendMessage(ChatColor.DARK_AQUA + "[ DOXSHOP ]" + ChatColor.WHITE + "보유 자산이 부족합니다.");
                            }
                            else {
                                player.sendMessage(ChatColor.DARK_AQUA + "[ DOXSHOP ]" + ChatColor.WHITE + "판매에 성공하였습니다.");
                                money[4] = Money;
                                Material material = event.getCurrentItem().getType();
                                ItemStack item = new ItemStack(material);
                                for (int o = 0; o < 64; o++){
                                    player.getInventory().addItem(item);
                                }
                            }

                        }
                    }
                    else if (event.isRightClick()){
                        if (ClickItem.get(i).contains("구매 금액 : ")){
                            int Money = Integer.parseInt(ClickItem.get(i).replace("구매 금액 : ","").replace(",","")) * 64;
                            Material material = event.getCurrentItem().getType();
                            ItemStack item = new ItemStack(material);
                            if  (item.getAmount() < 64) {
                                player.sendMessage(ChatColor.DARK_AQUA + "[ DOXSHOP ]" + ChatColor.WHITE + "판매할 물품이 없습니다.");
                            }else {
                                player.sendMessage(ChatColor.DARK_AQUA + "[ DOXSHOP ]" + ChatColor.WHITE + "구매에 성공하였습니다.");
                                money[5] = Money;
                                for (int o = 0; o < 64 ; o++) {
                                    player.getInventory().remove(item);
                                }
                            }
                        }
                    }
                    else if (!(event.isShiftClick())){
                        if (event.isLeftClick()){
                            if (ClickItem.get(i).contains("판매 금액 : ")){
                                int Money = Integer.parseInt(ClickItem.get(i).replace("판매 금액 : ","").replace(",",""));
                                if  (Money >= money[6]){
                                    player.sendMessage(ChatColor.DARK_AQUA + "[ DOXSHOP ]" + ChatColor.WHITE + "보유 자산이 부족합니다.");
                                }
                                else {
                                    player.sendMessage(ChatColor.DARK_AQUA + "[ DOXSHOP ]" + ChatColor.WHITE + "판매에 성공하였습니다.");
                                    money[4] = Money;
                                    Material material = event.getCurrentItem().getType();
                                    ItemStack item = new ItemStack(material);
                                    player.getInventory().addItem(item);
                                }

                            }
                            else if (ClickItem.get(i).contains("학습 비용 : ")){
                                Material material = event.getCurrentItem().getType();
                                NamespacedKey name = material.getKey();
                                if (player.hasDiscoveredRecipe(name)){
                                    player.sendMessage(ChatColor.DARK_AQUA + "[ DOXSHOP ]" + ChatColor.WHITE + "이미 학습한 내용입니다. 아니면 벌써 까먹으신건가요?");
                                } else {
                                    int Money = Integer.parseInt(ClickItem.get(i).replace("학습 비용 : ","").replace(",",""));
                                    if  (Money >= money[6]){
                                        player.sendMessage(ChatColor.DARK_AQUA + "[ DOXSHOP ]" + ChatColor.WHITE + "보유 자산이 부족합니다.");
                                    }
                                    else {
                                        player.sendMessage(ChatColor.DARK_AQUA + "[ DOXSHOP ]" + ChatColor.WHITE + "학습에 성공하였습니다.");
                                        money[4] = Money;

                                        player.performCommand("recipe give "+player.getName()+" "+material);
                                    }
                                }
                            }
                        }
                        else if (event.isRightClick()){
                            if (ClickItem.get(i).contains("구매 금액 : ")){
                                int Money = Integer.parseInt(ClickItem.get(i).replace("구매 금액 : ","").replace(",",""));
                                Material material = event.getCurrentItem().getType();
                                ItemStack item = new ItemStack(material);
                                if  (item.getAmount() < 1) {
                                    player.sendMessage(ChatColor.DARK_AQUA + "[ DOXSHOP ]" + ChatColor.WHITE + "판매할 물품이 없습니다.");
                                }else {
                                    player.sendMessage(ChatColor.DARK_AQUA + "[ DOXSHOP ]" + ChatColor.WHITE + "구매에 성공하였습니다.");
                                    money[5] = Money;
                                    player.getInventory().remove(item);
                                }
                            }
                        }
                    }
                    player.updateInventory();
                }
            }
        }
    }

}






























