package Mr_zhao.minecraft.bukkit.plugin.anitlag.listeners;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.AnitLag;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * Created by yzh on 16-7-23.
 */
public class AutoRespawnLIstener extends AnitLagListener {
    public AutoRespawnLIstener(AnitLag antiLag) {
        super(antiLag);
    }
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        e.getEntity().spigot().respawn();
    }
}
