package Mr_zhao.minecraft.bukkit.plugin.anitlag.listeners;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.AntiLag;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.List;

/**
 * Created by yzh on 16-7-14.
 */
public class ChunkEntityListener extends AntiLagListener {
    private int  entityLimit;
    private List<String> entityWhiteList;
    public  ChunkEntityListener(AntiLag p){
        super(p);
        entityLimit=getCfg().getChunkEntitySpawnLimit();
        entityWhiteList=getCfg().getChunkEntitySpawnWhileList();

    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntitySpawn(CreatureSpawnEvent e){
        if(e.getEntity().getLocation().getChunk().getEntities().length>entityLimit){
        if(!entityWhiteList.contains(e.getEntity().getType().getName())){
            e.setCancelled(true);
            return;

        }

        }
    }
}