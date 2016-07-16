package Mr_zhao.minecraft.bukkit.plugin.anitlag;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.Threads.ChunkUnloadThread;
import Mr_zhao.minecraft.bukkit.plugin.anitlag.Threads.ClearLagThread;
import Mr_zhao.minecraft.bukkit.plugin.anitlag.Threads.RedstoneCleaner;
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
            red=new RedstoneCleaner(this);
            red.start();

        }
        if(getConfig().getBoolean("CleanEntity.enable")){
            new ClearLagThread(this).start();
        }
        if(getConfig().getBoolean("NoBoom")){
            reg(new ExplodedListener(this));
        }
        if(getConfig().getBoolean("SpawnbyMan.enable")){
            reg(new ManMadeSpawnListener(this));
        }
        if(getConfig().getBoolean("Chunk.enable")){
            new ChunkUnloadThread(this).start();
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


    }

    public static Config getCfg(){
        return cfg;
    }

}

