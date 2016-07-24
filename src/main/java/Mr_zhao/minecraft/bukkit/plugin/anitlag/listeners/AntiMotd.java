package Mr_zhao.minecraft.bukkit.plugin.anitlag.listeners;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.AntiLag;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.server.ServerListPingEvent;

/**
 * Created by yzh on 16-7-24.
 */
public class AntiMotd extends AntiLagListener {
    public AntiMotd(AntiLag antiLag) {
        super(antiLag);
    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onServerPing(ServerListPingEvent e){
        String ip=e.getAddress().getHostAddress();
        AntiLag.addCount(ip,AntiLag.mot);
        if(AntiLag.mot.get(ip)>=getPlugin().getConfig().getInt("motdLimit")){
            e.setMaxPlayers(0);
            e.setServerIcon(null);
            e.setMotd("");
        }
    }
}
