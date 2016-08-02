package Mr_zhao.minecraft.bukkit.plugin.anitlag.listeners;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.AntiLag;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by yzh on 16-8-3.
 */
public class AntiEnchant extends AntiLagListener
{
    public AntiEnchant(AntiLag antiLag) {
        super(antiLag);
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){
        if(e.hasItem()&&e.getItem().getType()!= Material.AIR){
            for(Enchantment en:e.getItem().getEnchantments().keySet()){
                if(e.getItem().getEnchantments().get(en)>10){
                    e.setCancelled(true);
                }
            }
        }
    }
}
