package Mr_zhao.minecraft.bukkit.plugin.anitlag.listeners;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.AnitLag;
import org.bukkit.event.block.BlockRedstoneEvent;

/**
 * Created by yzh on 16-7-14.
 */
public class BlockRedstoneListener extends AnitLagListener{

    public BlockRedstoneListener(AnitLag antiLag) {
        super(antiLag);
    }
    public void onBlockRedStone(BlockRedstoneEvent e){
        getPlugin().getRedstoneThread().count(e.getBlock().getLocation());
    }
}
