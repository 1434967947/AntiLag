package Mr_zhao.minecraft.bukkit.plugin.anitlag.Threads;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.AnitLag;
import Mr_zhao.minecraft.bukkit.plugin.anitlag.configuration.Config;
import org.bukkit.plugin.Plugin;

/**
 * Created by yzh on 16-7-14.
 */
public class AnitLagThreads extends Thread{
    private AnitLag plugin;
    private Config cfg;
    public AnitLagThreads(AnitLag plugin)
    {
        this.plugin=plugin;
        cfg=plugin.getCfg();
    }


    protected Config getCfg(){
        return  this.cfg;

    }
    protected AnitLag getPlugin(){
        return  this.plugin;

    }
}
