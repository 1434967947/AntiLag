package Mr_zhao.minecraft.bukkit.plugin.anitlag.bugs.listener;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.AnitLag;
import Mr_zhao.minecraft.bukkit.plugin.anitlag.listeners.AnitLagListener;
import org.bukkit.block.Block;
import org.bukkit.block.Dispenser;
import org.bukkit.block.Dropper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Created by yzh on 16-7-16.
 */
public class UnlimitItems extends AnitLagListener{
    public UnlimitItems(AnitLag antiLag) {
        super(antiLag);
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){
        ItemStack item0=e.getPlayer().getInventory().getItemInMainHand();
        ItemStack item1=e.getPlayer().getInventory().getItemInOffHand();
         if(item0!=null&&item0.getAmount()<0){
             item0.setAmount(1);
             e.getPlayer().getInventory().setItemInMainHand(item0);
         }
        if(item1!=null&&item1.getAmount()<0){
            item1.setAmount(1);
            e.getPlayer().getInventory().setItemInMainHand(item1);
        }
    }
    @EventHandler
    public void onDispence(BlockDispenseEvent e){
        ItemStack item0=e.getItem();
        Inventory inv;
        if(e.getBlock() instanceof Dispenser){
            inv=((Dispenser) e.getBlock()).getInventory();
        }else {
            inv=((Dropper)e.getBlock()).getInventory();
        }
        for(int i=0; i<9;i++){
            ItemStack it=inv.getItem(i);
            if(it.getAmount()<0){
                it.setAmount(1);
                inv.setItem(i,it);
            }
        }

    }
}
