package Mr_zhao.minecraft.bukkit.plugin.anitlag.listeners;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.AntiLag;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockRedstoneEvent;

import java.util.HashMap;

/**
 * Created by yzh on 16-7-14.
 */
public class BlockRedstoneListener extends AntiLagListener {
    private HashMap<Location,Integer> cache;
    public BlockRedstoneListener(AntiLag antiLag) {
        super(antiLag);
        cache=AntiLag.cache;
    }
    public void count(Location loc){
        cache.put(loc,cache.get(loc)+1);
    }
    @EventHandler
    public void onBlockRedStone(BlockRedstoneEvent e){
         count(e.getBlock().getLocation());
    }
}
