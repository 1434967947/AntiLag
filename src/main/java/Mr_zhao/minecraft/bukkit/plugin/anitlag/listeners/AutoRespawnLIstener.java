package Mr_zhao.minecraft.bukkit.plugin.anitlag.listeners;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.AntiLag;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * Created by yzh on 16-7-23.
 */
public class AutoRespawnLIstener extends AntiLagListener {
    public AutoRespawnLIstener(AntiLag antiLag) {
        super(antiLag);
    }
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        e.getEntity().spigot().respawn();
    }
}
