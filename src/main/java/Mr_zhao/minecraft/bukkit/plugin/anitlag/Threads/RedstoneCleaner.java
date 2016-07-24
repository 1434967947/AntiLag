package Mr_zhao.minecraft.bukkit.plugin.anitlag.Threads;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.AntiLag;
import org.bukkit.Location;
import org.bukkit.Material;

import java.util.HashMap;

/**
 * Created by yzh on 16-7-14.
 */
public class RedstoneCleaner extends  AnitLagThreads{
    private HashMap<Location,Integer> cache;
    private long sleepTime;
    private  int clean;
    public RedstoneCleaner(AntiLag plugin) {
        super(plugin);
        cache=AntiLag.cache;
        clean=getCfg().getRedStoneCleanThreshold();
    }

    @Override
    public void run(){
    if(getCfg().getRedStoneShouldDrop()){

        for (Location loc:cache.keySet()){
            if(cache.get(loc)>clean){

                if(!loc.getBlock().getType().toString().startsWith("REDSTONE")){
                    loc.getBlock().breakNaturally();
                }

            }

        }
    }else{

        for (Location loc:cache.keySet()){
            if(cache.get(loc)>clean){
                if(!loc.getBlock().getType().toString().startsWith("REDSTONE")) {
                    loc.getBlock().setType(Material.AIR);
                }
            }

        }


}
    }
}
