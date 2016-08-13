package Mr_zhao.minecraft.bukkit.plugin.anitlag.listeners;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.AntiLag;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Created by yzh on 16-8-13.
 */
public class AntiKillg extends AntiLagListener {
    public AntiKillg(AntiLag antiLag) {
        super(antiLag);
    }
    @EventHandler
    public void onPlayerKill(EntityDamageByEntityEvent e){
        if(!(e.getDamager() instanceof Player)){
            return;
        }
        double i=getPlugin().getConfig().getDouble("kradius");
        if(!e.getEntity().getNearbyEntities(i,i,i).contains(e.getDamager())){
            e.setCancelled(true);
        }
    }
}
