package Mr_zhao.minecraft.bukkit.plugin.anitlag.Threads;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.AntiLag;
import Mr_zhao.minecraft.bukkit.plugin.anitlag.configuration.Config;

/**
 * Created by yzh on 16-7-14.
 */
public abstract class AnitLagThreads implements Runnable{
    private AntiLag plugin;
    private Config cfg;
    public AnitLagThreads(AntiLag plugin)
    {
        this.plugin=plugin;
        cfg=plugin.getCfg();

    }

     public abstract void run();

    protected Config getCfg(){
        return  this.cfg;

    }
    protected AntiLag getPlugin(){
        return  this.plugin;

    }
}
