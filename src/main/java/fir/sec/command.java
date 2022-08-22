package fir.sec;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class command implements TabExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (command.getName().equals("에르")){
                if (args.length == 0){
                    player.sendMessage("/에르 [꺼낼 금액] [꺼낼 개수]");
                }
                else {

                    if (args[0].equals("설정")){
                        if (args[1].equals("+")){
                            long[] Pmoney = Money.getMoney(player.getUniqueId().toString());
                            Pmoney[4] = Long.parseLong(args[2]);
                            Money.setMoney(player.getUniqueId().toString(), Pmoney);
                        }
                        if (args[1].equals("=")){
                            long[] Smoney = Money.getMoney(player.getUniqueId().toString());
                            Smoney[0] = 0;
                            Smoney[1] = 0;
                            Smoney[2] = 0;
                            Smoney[3] = 0;
                            Smoney[4] = Long.parseLong(args[2]);
                            Money.setMoney(player.getUniqueId().toString(), Smoney);
                        }
                        if (args[1].equals("-")){
                            long[] Mmoney = Money.getMoney(player.getUniqueId().toString());
                            Mmoney[5] = Long.parseLong(args[2]);
                            Money.setMoney(player.getUniqueId().toString(), Mmoney);
                        }
                    }
                    else if (args.length == 1) {
                        int money = 0;
                        long[] stat;
                        stat = Money.getMoney(player.getUniqueId().toString());
                        try {
                            money = Integer.parseInt(args[0]);
                        } catch (Exception e) {
                            player.sendMessage(ChatColor.DARK_AQUA + "[ DOXSHOP ]" + ChatColor.WHITE + "잘못된 정수가 기입되었습니다.");
                        }
                        if (money < 0) {
                            sender.sendMessage(ChatColor.DARK_AQUA + "[ DOXSHOP ]" + ChatColor.WHITE + "음수는 제공되지 않습니다 고객님 ^^7");
                        } else {
                            if (stat[6] > money) {
                                ItemStack paper = new ItemStack(Material.PAPER);
                                ItemMeta im = paper.getItemMeta();
                                assert im != null;
                                im.setDisplayName(ChatColor.DARK_AQUA + "[ DOXSHOP ] " + ChatColor.WHITE + args[0] + " 골드");
                                im.setLore(Arrays.asList(ChatColor.GRAY+"전 지역에서 활발하게 사용되는 화폐이다.",ChatColor.GRAY+"재질은 아르킨 제국의 하프의 털로 만들어져 부드럽다."));
                                paper.setItemMeta(im);
                                player.getInventory().addItem(paper);
                                stat[5] = money;
                                Money.setMoney(player.getUniqueId().toString(), stat);
                            }
                            else {
                                sender.sendMessage(ChatColor.DARK_AQUA + "[ DOXSHOP ]" + ChatColor.WHITE + "돈이 부족합니다.");
                            }
                        }
                    }
                    else if (args.length == 2) {
                        int money = 0;
                        int num = 0;
                        Player p = (Player) sender;
                        long[] stat;
                        stat = Money.getMoney(p.getUniqueId().toString());
                        try {
                            money = Integer.parseInt(args[0]);
                            num = Integer.parseInt(args[1]);
                        } catch (Exception e) {
                            p.sendMessage(ChatColor.DARK_AQUA + "[ DOXSHOP ]" + ChatColor.WHITE + "잘못된 정수가 기입되었습니다.");
                        }
                        if (money < 0) {
                            sender.sendMessage(ChatColor.DARK_AQUA + "[ DOXSHOP ]" + ChatColor.WHITE + "음수는 제공되지 않습니다 고객님 ^^7");
                        } else {
                            if (money < stat[6]){
                                ItemStack paper = new ItemStack(Material.PAPER);
                                ItemMeta im = paper.getItemMeta();
                                assert im != null;
                                im.setDisplayName(ChatColor.DARK_AQUA + "[ DOXSHOP ] " + ChatColor.WHITE + args[0] + " 골드");
                                im.setLore(Arrays.asList(ChatColor.GRAY+"전 지역에서 활발하게 사용되는 화폐이다.",ChatColor.GRAY+"재질은 아르킨 제국의 하프의 털로 만들어져 부드럽다."));
                                paper.setItemMeta(im);
                                for (int i = 0; i < num; i++) {
                                    p.getInventory().addItem(paper);
                                }
                                stat[5] = ((long) money * num);
                                Money.setMoney(p.getUniqueId().toString(), stat);
                            }else {
                                sender.sendMessage(ChatColor.DARK_AQUA + "[ DOXSHOP ]" + ChatColor.WHITE + "돈이 부족합니다.");
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (args.length == 0){
            return Collections.singletonList("에르");
        }
        else if (command.getName().equals("에르")){
            if (player.isOp()){
                if (args.length == 1){
                    return Arrays.asList("설정","< 꺼낼 금액 >");
                }
                else if (args.length == 2){
                    if (args[0].equals("설정")){
                        return Arrays.asList("+","=","-");
                    }
                }
            }
            else if (args.length == 1){
                return Collections.singletonList("< 꺼낼 금액 >");
            }
            else if (args.length == 2){
                return Collections.singletonList("< 꺼낼 개수 >");
            }
        }
        return null;
    }
}




































