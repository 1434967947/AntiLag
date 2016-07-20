package Mr_zhao.minecraft.bukkit.plugin.anitlag.Threads;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.AnitLag;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;

/**
 * Created by yzh on 16-7-15.
 */
public class ChunkUnloadThread extends AnitLagThreads{


    public ChunkUnloadThread(AnitLag plugin) {
        super(plugin);
    }
    @Override
    public void run(){

    for(String s:getCfg().getChunkUnloadWorld()){
        World w= Bukkit.getWorld(s);
        if(w!=null)
            for(Chunk c:w.getLoadedChunks()){
                c.unload();
            }
    }



    }
}
