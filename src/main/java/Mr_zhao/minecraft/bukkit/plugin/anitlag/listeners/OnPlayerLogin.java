package Mr_zhao.minecraft.bukkit.plugin.anitlag.listeners;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.AntiLag;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerLoginEvent;

/**
 * Created by yzh on 16-7-23.
 */
public class OnPlayerLogin extends AntiLagListener {

    public OnPlayerLogin(AntiLag antiLag) {
        super(antiLag);
    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerLogin(PlayerLoginEvent e){
        String ip=e.getAddress().getHostAddress();
        if(getCfg().getSuperBanIp().contains(ip)){
            getCfg().addBanList(e.getPlayer().getName());
            e.disallow(PlayerLoginEvent.Result.KICK_BANNED,"你的ip已经被封禁");
            return;
        }
        if(getCfg().getSuperBanList().contains(e.getPlayer().getName())){
            e.disallow(PlayerLoginEvent.Result.KICK_BANNED,"你已经被封禁");
            getCfg().addBanip(e.getAddress().getHostAddress());
            return;
        }

    }
}