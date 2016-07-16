package Mr_zhao.minecraft.bukkit.plugin.anitlag.bugs.listener;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.AnitLag;
import Mr_zhao.minecraft.bukkit.plugin.anitlag.listeners.AnitLagListener;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityPortalEvent;

/**
 * Created by yzh on 16-7-16.
 */
public class MinecraftPortal extends AnitLagListener{

    public MinecraftPortal(AnitLag antiLag) {
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