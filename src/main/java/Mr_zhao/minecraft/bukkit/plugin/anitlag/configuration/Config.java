package Mr_zhao.minecraft.bukkit.plugin.anitlag.configuration;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.AntiLag;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yzh on 16-7-14.
 */
public class Config {
    private FileConfiguration cfg;
    public Config(AntiLag a){
        try {
            cfg= YamlConfiguration.loadConfiguration(new InputStreamReader(new DataInputStream(new BufferedInputStream(new FileInputStream(new File(a.getDataFolder(),"config.yml")))),"UTF-8"));
        } catch (FileNotFoundException e) {
           a.saveDefaultConfig();
            cfg=a.getConfig();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
    public  int getEggCheckRadius(){
        return  cfg.getInt("SpawnbyMan.egg.radius");
    }
    public  int getEggLimits(){
        return  cfg.getInt("SpawnbyMan.egg.limit");
    }
    public  String getEggLimitsMsg(){
        return ChatColor.translateAlternateColorCodes('&',cfg.getString("SpawnbyMan.egg.broadcase"));
    }
    public  int getBreedingCheckRadius(){
        return  cfg.getInt("SpawnbyMan.breeding.radius");
    }
    public  int getBreedingLimits(){
        return  cfg.getInt("SpawnbyMan.breeding.limit");
    }
    public  String getBreedingLimitsMsg(){
        return ChatColor.translateAlternateColorCodes('&',cfg.getString("SpawnbyMan.breeding.broadcase"));
    }
    public int getChunkEntitySpawnLimit(){
        return cfg.getInt("Chunk.EntityLimit");
    }
    public List<String> getChunkEntitySpawnWhileList(){
        return cfg.getStringList("Chunk.EntityWhitelist");
    }
    public long getRedStoneChecktime(){
        return cfg.getInt("Redstone.checktime")*20;
    }
    public int getRedStoneCleanThreshold(){
        return cfg.getInt("Redstone.cleanThreshold");
    }
    public  boolean getRedStoneShouldDrop(){
        return cfg.getBoolean("Redstone.drop");
    }
    public  List<Integer> getItemWhileList(){

        return  cfg.getIntegerList("CleanEntity.itemWhilelist");
    }
    public  List<World> getWorlds(){
        List<World> worlds=new ArrayList<World>();
        for(String s:cfg.getStringList("CleanEntity.worlds")){
            World w=Bukkit.getWorld(s);
            if(w!=null){
                worlds.add(w);
            }
        }
        return worlds;
    }
    public boolean getWheaterCleanNamed(){
        return cfg.getBoolean("CleanEntity.Named");
    }

    public List<String > getEntityList(){

        return cfg.getStringList("CleanEntity.EntityWhitelist");
    }
    public List<String > getOps(){
        return cfg.getStringList("AnitOp.ops");
    }
    public boolean getBan(){
        return cfg.getBoolean("AnitOp.Superban");
    }
    public List<String > getChunkUnloadWorld(){
        return cfg.getStringList("Chunk.ChunkWorldList");
    }
    public List<String > getSuperBanList(){
        return cfg.getStringList("SuperBanList");
    }
    public void setSuperBanList(List<String> l){
          cfg.set("SuperBanList",l);
    }
    public List<String > getSuperBanIp(){
        return cfg.getStringList("SuperBanIp");
    }
    public void addBanip(String s){
        List l=getSuperBanIp();
        if(!(l.contains(s))){
            l.add(s);
            setSuperBanIp(l);
        }
    }
    public void addBanList(String s){
        List l=getSuperBanList();
      if(!(l.contains(s))){
          l.add(s);
          setSuperBanList(l);
      }
    }
    public List<String> getRudeWords(){
        return cfg.getStringList("Spam.rude");
    }
    public void setSuperBanIp(List<String> l){
        cfg.set("SuperBanIpt",l);
    }
    public long getChunkUnloadDelay(){
        return cfg.getInt("Chunk.ChunkGctime")*20;
    }
    public double getChatCooldown(){

        return cfg.getLong("Spam.chatCooldown");
    }
    public double getCommandCooldown(){
        return cfg.getLong("Spam.commandCooldown");
    }
    /*
    Redstone:
    enable: true
    checktime: 5 #单位秒
    : 10 #check
     */
}
