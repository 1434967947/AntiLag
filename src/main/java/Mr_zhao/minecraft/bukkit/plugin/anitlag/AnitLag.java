package Mr_zhao.minecraft.bukkit.plugin.anitlag;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.Threads.AnitLagThreads;
import Mr_zhao.minecraft.bukkit.plugin.anitlag.Threads.ChunkUnloadThread;
import Mr_zhao.minecraft.bukkit.plugin.anitlag.Threads.ClearLagThread;
import Mr_zhao.minecraft.bukkit.plugin.anitlag.Threads.RedstoneCleaner;
import Mr_zhao.minecraft.bukkit.plugin.anitlag.bugs.listener.ItemPortal;
import Mr_zhao.minecraft.bukkit.plugin.anitlag.bugs.listener.MinecraftPortal;
import Mr_zhao.minecraft.bukkit.plugin.anitlag.bugs.listener.Rail;
import Mr_zhao.minecraft.bukkit.plugin.anitlag.bugs.listener.UnlimitItems;
import Mr_zhao.minecraft.bukkit.plugin.anitlag.configuration.Config;
import Mr_zhao.minecraft.bukkit.plugin.anitlag.listeners.ChunkEntityListener;
import Mr_zhao.minecraft.bukkit.plugin.anitlag.listeners.ExplodedListener;
import Mr_zhao.minecraft.bukkit.plugin.anitlag.listeners.ManMadeSpawnListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by yzh on 16-7-14.
 */
public class AnitLag extends JavaPlugin  {
public static  Config cfg;
    public static RedstoneCleaner red;
    public static AnitLag plugin;
    public static  RedstoneCleaner getRedstoneThread(){
        return red;
    }
    private void reg(Listener l){
        Bukkit.getPluginManager().registerEvents(l,this);
    }
    @Override
    public void onEnable(){
    this.saveDefaultConfig();
cfg=new Config(this);
        plugin=this;
        if(getConfig().getBoolean("Redstone.enable")){
            runTimer(new RedstoneCleaner(this),getCfg().getRedStoneChecktime());
//;
        }
        if(getConfig().getBoolean("CleanEntity.enable")){
            runTimer(new ClearLagThread(this),getConfig().getInt("CleanEntity.sleep")*20);
        }
        if(getConfig().getBoolean("NoBoom")){
            reg(new ExplodedListener(this));
        }
        if(getConfig().getBoolean("SpawnbyMan.enable")){
            reg(new ManMadeSpawnListener(this));
        }
        if(getConfig().getBoolean("Chunk.enable")){

            runTimer(new ChunkUnloadThread(this),getCfg().getChunkUnloadDelay());
            reg(new ChunkEntityListener(this));
        }
        if(getConfig().getBoolean("Bugs.UnlimitRail")){
            reg(new Rail(this));
        }
        if(getConfig().getBoolean("Bugs.UnlimitItem")){
            reg(new UnlimitItems(this));
        }
        if(getConfig().getBoolean("Bugs.AnitMinecraftPortal")){
            reg(new MinecraftPortal(this));
        }
        if(getConfig().getBoolean("Bugs.AskyblockUnlimitItem")){
            reg(new ItemPortal(this));
        }


    }
    private void runTimer(AnitLagThreads run,long time){
        Bukkit.getScheduler().runTaskTimer(this,run,0,time);
    }
    public static Config getCfg(){
        return cfg;
    }

}

