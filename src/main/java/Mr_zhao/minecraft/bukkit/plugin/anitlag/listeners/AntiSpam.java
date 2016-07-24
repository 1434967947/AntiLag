package Mr_zhao.minecraft.bukkit.plugin.anitlag.listeners;

import Mr_zhao.minecraft.bukkit.plugin.anitlag.AntiLag;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Created by yzh on 16-7-24.
 */
public class AntiSpam extends AntiLagListener {
    public AntiSpam(AntiLag antiLag) {
        super(antiLag);
    }
    private void count(String s){
       AntiLag.chatc.add(s);
    }
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){
        if(e.getPlayer().isOp()||e.getPlayer().hasPermission("lag.Spam")){return;}
        if (AntiLag.chatc.contains(e.getPlayer())){
            e.getPlayer().sendMessage("说话慢一些");
            return;
        }
        if(e.getMessage().matches(getPlugin().getConfig().getString("Spam.serverformat"))){
            e.setCancelled(true);
            e.getPlayer().sendMessage("你不能宣传服务器");
            return;
        }
      for(String s:this.getCfg().getRudeWords()){
          if(e.getMessage().contains(s)){
              e.setCancelled(true);
              e.getPlayer().sendMessage("你不能说脏话");
              return;
          }
      }
    count(e.getPlayer().getName());
    }
}
