package fir.sec;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class DoxaShop extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new Money(),this);
        getServer().getPluginManager().registerEvents(new Join(),this);
        getServer().getPluginManager().registerEvents(new Interact(),this);
        getServer().getPluginManager().registerEvents(new Death(), this);
        getServer().getPluginManager().registerEvents(new Item(), this);
        getServer().getPluginManager().registerEvents(new Gui(), this);
        getLogger().info("Doxa Shop On");
        getServer().getScheduler().scheduleSyncRepeatingTask(this, () -> {
            for (Player player : getServer().getOnlinePlayers()){
                long[] money = Money.getMoney(player.getUniqueId().toString());
                if (!(money == null)) {
                    if (money[4] >= 1000000000){
                        for (int totalmoney = (int) money[4]; totalmoney >= 999999999; totalmoney--){
                            money[3] = money[3] + 1 ;
                            money[4] = totalmoney;
                        }
                    }
                    if (money[4] <= 999999999 && money[4] >= 1000000){
                        for (int totalmoney = (int) money[4]; totalmoney >= 999999; totalmoney--){
                            money[2] = money[2] + 1 ;
                            money[4] = totalmoney;
                        }
                    }
                    if (money[4] <= 999999 && money[4] >= 1000){
                        for (int totalmoney = (int) money[4]; totalmoney >= 999; totalmoney--){
                            money[1] = money[1] + 1 ;
                            money[4] = totalmoney;
                        }
                    }
                    if (money[4] <= 999 ){
                        for (int totalmoney =  (int) money[4]; totalmoney >= 0; totalmoney--){
                            money[0] = money[0] + 1;
                            money[4] = totalmoney;
                        }
                    }
                    if (money[5] >= 1000000000){
                        for (int totalmoney = (int) money[4]; totalmoney >= 999999999; totalmoney--){
                            money[3] = money[3] - 1 ;
                            money[5] = totalmoney;
                        }
                    }
                    if (money[5] <= 999999999 && money[4] >= 1000000){
                        for (int totalmoney = (int) money[4]; totalmoney >= 999999; totalmoney--){
                            money[2] = money[2] - 1 ;
                            money[5] = totalmoney;
                        }
                    }
                    if (money[5] <= 999999 && money[4] >= 1000){
                        for (int totalmoney = (int) money[4]; totalmoney >= 999; totalmoney--){
                            money[1] = money[1] - 1 ;
                            money[5] = totalmoney;
                        }
                    }
                    if (money[5] <= 999 ){
                        for (int totalmoney =  (int) money[4]; totalmoney >= 0; totalmoney--){
                            money[0] = money[0] - 1;
                            money[5] = totalmoney;
                        }
                    }

                    String money0 = "000";
                    String money1 = "000";
                    String money2 = "000";
                    String money3 = String.valueOf(money[3]);


                    if (100 > money[0] && money[0] >= 10){
                        money0 = "0"+money[0];
                    }
                    else if (10 > money[0] && money[0] >= 1){
                        money0 = "00"+money[0];
                    }
                    else if (money[0] == 0){
                        money0 = "000";
                    }

                    if (100 > money[1] && money[1] >= 10){
                        money1 = "0"+money[1];
                    }
                    else if (10 > money[1] && money[1] >= 1){
                        money1 = "00"+money[1];
                    }
                    else if (money[1] == 0){
                        money1 = "000";
                    }

                    if (100 > money[2] && money[2] >= 10){
                        money2 = "0"+money[2];
                    }
                    else if (10 > money[2] && money[2] >= 1){
                        money2 = "00"+money[2];
                    }
                    else if (money[2] == 0){
                        money2 = "000";
                    }


                    if (money[3] == 0){
                        if (money[2] == 0){
                            if (money[1] == 0){
                                player.spigot().sendMessage(ChatMessageType.ACTION_BAR,new TextComponent("보유 자산 : " + money0+"에르"));
                            }
                            else {
                                player.spigot().sendMessage(ChatMessageType.ACTION_BAR,new TextComponent("보유 자산 : " + money1+"," + money0+"에르"));
                            }
                        }
                        else {
                            player.spigot().sendMessage(ChatMessageType.ACTION_BAR,new TextComponent("보유 자산 : " + money2+"," + money1+"," + money0+"에르"));
                        }
                    }
                    else {
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR,new TextComponent("보유 자산 : " + money3 +","+ money2+"," + money1+"," + money0+"에르"));
                    }
                    String total;
                    if (money[3] == 0){
                        if (money[2] == 0){
                            if (money[1] == 0){
                                if (money[0] == 0){
                                    total = "0";
                                }
                                else {
                                    total = String.valueOf(money[0]);
                                }
                            }
                            else {
                                total = money[1] +""+ money[0];
                            }
                        }
                        else {
                            total = money[2] +""+ money[1] +""+ money[0];
                        }
                    }
                    else {
                        total = money[3] + "" + money[2] + "" + money[1] + "" + money[0];
                    }
                    money[6] = Long.parseLong(total);

                }
            }
        },0,0);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Doxa Shop Off");
    }
}
































