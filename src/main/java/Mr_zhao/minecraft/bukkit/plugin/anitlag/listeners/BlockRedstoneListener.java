package Mr_zhao.minecraft.bukkit.plugin.anitlag.listeners;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.AntiLag;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockRedstoneEvent;

/**
 * Created by yzh on 16-7-14.
 */
public class BlockRedstoneListener extends AntiLagListener {

    public BlockRedstoneListener(AntiLag antiLag) {
        super(antiLag);
    }
    @EventHandler
    public void onBlockRedStone(BlockRedstoneEvent e){
        getPlugin().getRedstoneThread().count(e.getBlock().getLocation());
    }
}
