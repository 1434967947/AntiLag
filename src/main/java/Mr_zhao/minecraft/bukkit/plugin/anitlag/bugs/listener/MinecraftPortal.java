package Mr_zhao.minecraft.bukkit.plugin.anitlag.bugs.listener;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.AntiLag;
import Mr_zhao.minecraft.bukkit.plugin.anitlag.listeners.AntiLagListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityPortalEvent;

/**
 * Created by yzh on 16-7-16.
 */
public class MinecraftPortal extends AntiLagListener {

    public MinecraftPortal(AntiLag antiLag) {
        super(antiLag);
    }
    @EventHandler
    public void onEntityPortal(EntityPortalEvent e)
    {
        if (e.getEntityType().getName().startsWith("MINE")){
            e.setCancelled(true);
        }
}
}