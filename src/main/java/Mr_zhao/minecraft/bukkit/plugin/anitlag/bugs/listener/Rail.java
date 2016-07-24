package Mr_zhao.minecraft.bukkit.plugin.anitlag.bugs.listener;


import Mr_zhao.minecraft.bukkit.plugin.anitlag.AntiLag;
import Mr_zhao.minecraft.bukkit.plugin.anitlag.listeners.AntiLagListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPhysicsEvent;

/**
 * Created by yzh on 16-7-16.
 */
public class Rail extends AntiLagListener {
    public Rail(AntiLag antiLag) {
        super(antiLag);
    }
    @EventHandler
    public void onBlockPhysics(BlockPhysicsEvent e)
    {
        if(e.getBlock().getType().name().contains("RAIL"))
            e.setCancelled(true);
    }
}
