package Mr_zhao.minecraft.bukkit.plugin.anitlag.listeners;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.AntiLag;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.server.ServerListPingEvent;

/**
 * Created by yzh on 16-7-24.
 */
public class AntiRobot extends AntiLagListener{
    public AntiRobot(AntiLag antiLag) {
        super(antiLag);
    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerLoginEvent e){
        String ip=e.getAddress().getHostAddress();
        AntiLag.addCount(ip,AntiLag.rob);
        if(AntiLag.rob.get(ip)>=getPlugin().getConfig().getInt("robotLimit")){
            e.disallow(PlayerLoginEvent.Result.KICK_BANNED,"");

        }
    }
}
