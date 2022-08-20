package fir.sec;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {

    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        long[] money = Money.getMoney(player.getUniqueId().toString());
        if (money == null){
            Money.CreateMoney(player.getUniqueId().toString());
            e.setJoinMessage("첫 접속을 환영합니다. "+player.getName()+ "주민님.");
        }
        else {
            e.setJoinMessage("환영합니다! "+player.getName()+ "주민님!");
        }
    }

}
