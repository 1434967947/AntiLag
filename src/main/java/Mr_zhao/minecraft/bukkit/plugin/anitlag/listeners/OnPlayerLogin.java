package Mr_zhao.minecraft.bukkit.plugin.anitlag.listeners;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.AnitLag;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerLoginEvent;

/**
 * Created by yzh on 16-7-23.
 */
public class OnPlayerLogin extends  AnitLagListener{

    public OnPlayerLogin(AnitLag antiLag) {
        super(antiLag);
    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerLogin(PlayerLoginEvent e){
        String ip=e.getAddress().getHostAddress();
        if(getCfg().getSuperBanIp().contains(ip)){
            getCfg().addBanList(e.getPlayer().getName());
            e.setResult(PlayerLoginEvent.Result.KICK_BANNED);
            return;
        }
        if(getCfg().getSuperBanList().contains(e.getPlayer().getName())){
            e.setResult(PlayerLoginEvent.Result.KICK_BANNED);
            getCfg().addBanip(e.getAddress().getHostAddress());
            return;
        }

    }
}