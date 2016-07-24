package Mr_zhao.minecraft.bukkit.plugin.anitlag.listeners;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.AntiLag;
import Mr_zhao.minecraft.bukkit.plugin.anitlag.configuration.Config;
import org.bukkit.event.Listener;

/**
 * Created by yzh on 16-7-14.
 */
public class AntiLagListener implements Listener {
    private Config cfg;
    private AntiLag plugin;
    public AntiLagListener(AntiLag antiLag){
        plugin=antiLag;
        cfg=plugin.getCfg();
    }
    protected Config getCfg(){
        return  this.cfg;

    }
    protected AntiLag getPlugin(){
        return  this.plugin;

    }
}