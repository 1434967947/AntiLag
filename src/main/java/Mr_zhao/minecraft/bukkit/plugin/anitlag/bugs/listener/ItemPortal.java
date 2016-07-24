package Mr_zhao.minecraft.bukkit.plugin.anitlag.bugs.listener;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.AntiLag;
import Mr_zhao.minecraft.bukkit.plugin.anitlag.listeners.AntiLagListener;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityPortalEvent;

/**
 * Created by yzh on 16-7-23.
 */
public class ItemPortal extends AntiLagListener {
    public ItemPortal(AntiLag antiLag) {
        super(antiLag);
    }
    @EventHandler
    public void onEntityPortal(EntityPortalEvent e){
        if(e.getEntity() instanceof Item){
            e.setCancelled(true);
        }
    }
}
