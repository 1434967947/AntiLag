package Mr_zhao.minecraft.bukkit.plugin.anitlag.bugs.listener;


import Mr_zhao.minecraft.bukkit.plugin.anitlag.AnitLag;
import Mr_zhao.minecraft.bukkit.plugin.anitlag.listeners.AnitLagListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPhysicsEvent;

/**
 * Created by yzh on 16-7-16.
 */
public class Rail extends AnitLagListener{
    public Rail(AnitLag antiLag) {
        super(antiLag);
    }
    @EventHandler
    public void onBlockPhysics(BlockPhysicsEvent e)
    {
        if(e.getBlock().getType().name().contains("RAIL"))
            e.setCancelled(true);
    }
}
