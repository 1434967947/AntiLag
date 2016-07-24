package Mr_zhao.minecraft.bukkit.plugin.anitlag.listeners;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.AntiLag;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by yzh on 16-7-24.
 */
public class AntiPortal extends AntiLagListener{

    public AntiPortal(AntiLag antiLag) {
        super(antiLag);
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Location loc=e.getPlayer().getLocation();
        if(loc.getBlock().getType()== Material.PORTAL){
            if(getPlugin().getConfig().getBoolean("Portal.break")){
                loc.getBlock().breakNaturally();
            }else{
                e.getPlayer().chat(getPlugin().getConfig().getString("Portal.command"));
            }
        }
    }
}
