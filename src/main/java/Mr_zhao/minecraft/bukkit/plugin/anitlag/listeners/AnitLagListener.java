package Mr_zhao.minecraft.bukkit.plugin.anitlag.listeners;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.AnitLag;
import Mr_zhao.minecraft.bukkit.plugin.anitlag.configuration.Config;
import org.bukkit.event.Listener;

/**
 * Created by yzh on 16-7-14.
 */
public class AnitLagListener implements Listener {
    private Config cfg;
    private  AnitLag plugin;
    public AnitLagListener(AnitLag antiLag){
        plugin=antiLag;
        cfg=plugin.getCfg();
    }
    protected Config getCfg(){
        return  this.cfg;

    }
    protected AnitLag getPlugin(){
        return  this.plugin;

    }
}