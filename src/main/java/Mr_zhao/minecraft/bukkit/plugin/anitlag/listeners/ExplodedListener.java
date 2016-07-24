package Mr_zhao.minecraft.bukkit.plugin.anitlag.listeners;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.AntiLag;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityExplodeEvent;

/**
 * Created by yzh on 16-7-14.
 */
public class ExplodedListener extends AntiLagListener {
    public ExplodedListener(AntiLag antiLag) {
        super(antiLag);
    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public  void  onEntityExplore(EntityExplodeEvent e){
             e.setCancelled(true);

    }
}
