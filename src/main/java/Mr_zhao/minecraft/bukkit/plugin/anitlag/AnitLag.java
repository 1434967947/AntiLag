package Mr_zhao.minecraft.bukkit.plugin.anitlag;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.Threads.*;
import Mr_zhao.minecraft.bukkit.plugin.anitlag.bugs.listener.ItemPortal;
import Mr_zhao.minecraft.bukkit.plugin.anitlag.bugs.listener.MinecraftPortal;
import Mr_zhao.minecraft.bukkit.plugin.anitlag.bugs.listener.Rail;
import Mr_zhao.minecraft.bukkit.plugin.anitlag.bugs.listener.UnlimitItems;
import Mr_zhao.minecraft.bukkit.plugin.anitlag.configuration.Config;
import Mr_zhao.minecraft.bukkit.plugin.anitlag.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * Created by yzh on 16-7-14.
 */
public class AnitLag extends JavaPlugin  {
public static  Config cfg;
    public static RedstoneCleaner red;
    public static AnitLag plugin;
    private  boolean b=false;
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
        if(getConfig().getBoolean("AnitOp.enable")){
            b=true;
            runTimer(new CheckOpersThread(this),getConfig().getLong("AnitOp.check"));
        }
        if(getConfig().getBoolean("SuperBan")){
            reg(new OnPlayerLogin(this));
        }
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
        if(getConfig().getBoolean("AutoRespawn")){
            reg(new AutoRespawnLIstener(this));
        }


    }
    private void runTimer(AnitLagThreads run,long time){
        Bukkit.getScheduler().runTaskTimer(this,run,0,time);
    }
    public static Config getCfg(){
        return cfg;
    }@Override
    public void onDisable(){
        saveConfig();
    }
@Override
public boolean onCommand(final CommandSender sender, Command command, String label, String[] args) {
  if(command.getName().equals("lagr")){
        if(sender.hasPermission("lag.reload")){
            reloadConfig();
            sender.sendMessage("Plugin Reloaded");
            return true;
        }

    }
    if (b &&(command.getName().equals("op")||command.getName().equals("deop"))){
        if(!(sender instanceof ConsoleCommandSender)){
            sender.sendMessage("这个指令只能在后台执行");
        }
    }
    if(command.getName().equals("superban")){
        if(sender.hasPermission("lag.ban")){
            if(args.length>0){
                String tmp=args[0];
                if(tmp.contains(".")){
                    getCfg().addBanip(tmp);
                    sender.sendMessage("ip添加成功"+tmp);

                }else{
                    getCfg().addBanList(tmp);
                    sender.sendMessage("玩家添加成功"+tmp);
                }



                saveConfig();
            }else {
                sender.sendMessage("输入/superban 名字或者ip 来封人");
            }

        }else {
            sender.sendMessage("你没有权限封人");
        }
    }


    return  true;
}

}

