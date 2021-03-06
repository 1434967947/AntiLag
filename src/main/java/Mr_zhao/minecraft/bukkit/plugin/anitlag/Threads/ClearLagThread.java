package Mr_zhao.minecraft.bukkit.plugin.anitlag.Threads;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.AntiLag;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;

import java.util.Collection;

/**
 * Created by yzh on 16-7-14.
 */
public class ClearLagThread extends AnitLagThreads {
    public ClearLagThread(AntiLag plugin) {
        super(plugin);
    }
    private void cleanEntitys(Collection<World> worlds){

        for(World w:worlds){
            for(Entity e:w.getEntities()){
                if(e instanceof Item ){
                    if(!(getCfg().getItemWhileList().contains(((Item) e).getItemStack().getTypeId()))) {
                        e.remove();
                    }else    if ((!getCfg().getWheaterCleanNamed())&&(

                        !((Item) e).getItemStack().getItemMeta().hasDisplayName() || ((Item) e).getItemStack().getItemMeta().hasLore()
                                || !((Item) e).getItemStack().getItemMeta().hasEnchants())){
                            e.remove();
                        }

                }else{
                    if ((getCfg().getEntityList().contains(e.getType().getName()))&&(e.getName()!=e.getCustomName())){
                        e.remove();
                    }
                }
            }
        }
    }

    @Override
    public  void  run(){

            cleanEntitys(getCfg().getWorlds());
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',getPlugin().getConfig().getString("CleanEntity.msg")));


    }
}
