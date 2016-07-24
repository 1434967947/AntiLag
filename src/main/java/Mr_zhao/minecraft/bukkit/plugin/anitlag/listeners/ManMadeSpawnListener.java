package Mr_zhao.minecraft.bukkit.plugin.anitlag.listeners;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.AntiLag;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.List;

/**
 * Created by yzh on 16-7-14.
 */
public class ManMadeSpawnListener extends AntiLagListener {
    public ManMadeSpawnListener(AntiLag antiLag) {
        super(antiLag);
        getCfg().getChunkEntitySpawnLimit();
    }
    private List<Entity> getNearbyEntitys(Entity e,int r){
        return  e.getNearbyEntities(r,r,r);
    }
    private void broadCase(List<Entity> entitys,String msg){

        for(Entity e:entitys){
            if(e instanceof Player){
               e.sendMessage(msg);
            }
        }

    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public  void onPlayerBreeding(CreatureSpawnEvent e){
        if(e.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.BREEDING)){
            List<Entity> entitys=getNearbyEntitys(e.getEntity(),getCfg().getBreedingCheckRadius());
            if (entitys.size()>getCfg().getBreedingLimits()){
                e.setCancelled(true);
                broadCase(entitys,getCfg().getBreedingLimitsMsg());

                return;

            }
        }

    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEggSpawn(CreatureSpawnEvent e){

        if(e.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.EGG)){
            List<Entity> entitys=getNearbyEntitys(e.getEntity(),getCfg().getEggCheckRadius());
            if (entitys.size()>getCfg().getEggLimits()){
                e.setCancelled(true);
                broadCase(entitys,getCfg().getEggLimitsMsg());

                return;

            }

        }

    }

}
