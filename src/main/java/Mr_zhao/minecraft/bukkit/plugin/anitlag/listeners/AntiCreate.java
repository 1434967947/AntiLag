package Mr_zhao.minecraft.bukkit.plugin.anitlag.listeners;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.AntiLag;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerGameModeChangeEvent;

/**
 * Created by yzh on 16-7-24.
 */
public class AntiCreate extends AntiLagListener {
    public AntiCreate(AntiLag antiLag) {
        super(antiLag);
    }
    @EventHandler
    public void onPlayerGamemode(PlayerGameModeChangeEvent e){
        if(e.getNewGameMode()==GameMode.CREATIVE){
            if(!getPlugin().getConfig().getString("CreateList").contains(e.getPlayer().getName())){
                if(getPlugin().getConfig().getBoolean("gamemodeban")) {
                    getCfg().addBanList(e.getPlayer().getName());
                }else {
                    e.setCancelled(true);
                    e.getPlayer().sendMessage("禁止非法创造");
                }
            }
        }
    }

}
