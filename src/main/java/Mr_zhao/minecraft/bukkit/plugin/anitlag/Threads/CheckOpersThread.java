package Mr_zhao.minecraft.bukkit.plugin.anitlag.Threads;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.AnitLag;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;

import java.util.List;

/**
 * Created by yzh on 16-7-23.
 */
public class CheckOpersThread extends AnitLagThreads {
    public CheckOpersThread(AnitLag plugin) {
        super(plugin);
    }

    public void run() {
        List<String> ops=getCfg().getOps();
    for(OfflinePlayer p: Bukkit.getOperators()){
        if(!ops.contains(p.getName())){
            p.setOp(false);
            if(getCfg().getBan()){
               List<String> n= getCfg().getSuperBanList();
                n.add(p.getName());
                getCfg().setSuperBanList(n);
                if(p.isOnline()){
                   p.getPlayer().kickPlayer("");



                    getCfg().addBanip(p.getPlayer().getAddress().getAddress().getHostAddress());
                    p.getPlayer().setGameMode(GameMode.SPECTATOR);
                }

            }
        }
    }
    }
}
