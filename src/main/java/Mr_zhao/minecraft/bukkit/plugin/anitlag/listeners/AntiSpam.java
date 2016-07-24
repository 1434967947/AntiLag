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

        if(getPlugin().getConfig().getBoolean("Spam.Similar")){
            if(getSimilarDegree(e.getMessage(),AntiLag.chatcache.get(e.getPlayer().getName()))>=getPlugin().getConfig().getDouble("Spam.degree")){
                e.getPlayer().sendMessage("请不要发二句相似的话");
                e.setCancelled(true);
            }
        }


        AntiLag.chatcache.put(e.getPlayer().getName(),e.getMessage());
    }
    private double getSimilarDegree(String str1,String str2){
    String st1=removeSigns(str1);
        String st2=removeSigns(str2);
        int temp = Math.max(st1 .length(), st2.length());

        int temp2 = longestCommonSubstring(st1,st2).length();

        return temp2 * 1.0 / temp;
    }
    private String removeSigns(String str){
StringBuffer sb=new StringBuffer();
        for(char c:str.toCharArray()){
            if(isChar(c))
                sb.append(c);
        }
        return sb.toString();
    }
    private static boolean isChar(char charValue) {

        return (charValue >= 0x4E00 && charValue <= 0X9FA5)

                || (charValue >= 'a' && charValue <= 'z')

                || (charValue >= 'A' && charValue <= 'Z')

                || (charValue >= '0' && charValue <= '9');

    }
    private static String longestCommonSubstring(String strA, String strB) {

        char[] chars_strA = strA.toCharArray();

        char[] chars_strB = strB.toCharArray();

        int m = chars_strA.length;

        int n = chars_strB.length;

        int[][] matrix = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                if (chars_strA[i - 1] == chars_strB[j - 1])

                    matrix[i][j] = matrix[i - 1][j - 1] + 1;

                else

                    matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);

            }

        }

        char[] result = new char[matrix[m][n]];

        int currentIndex = result.length - 1;

        while (matrix[m][n] != 0) {

            if (matrix[n] == matrix[n - 1])

                n--;

            else if (matrix[m][n] == matrix[m - 1][n])

                m--;

            else {

                result[currentIndex] = chars_strA[m - 1];

                currentIndex--;

                n--;

                m--;

            }
        }

        return new String(result);

    }
}
