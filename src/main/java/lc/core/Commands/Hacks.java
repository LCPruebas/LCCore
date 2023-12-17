package lc.core.Commands;

import lc.core.Controller.Jugador;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Hacks implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if(sender instanceof Player) {
            Player pl = (Player) sender;

            if(!Jugador.getJugador(pl).is_AYUDANTE()) {
                return true;
            }
        }

        sender.sendMessage(ChatColor.RED+"- Posibles usuarios con killaura -");

        for(Player Online : Bukkit.getOnlinePlayers()) {
           // EntityPlayer ep = ((CraftPlayer) Online).getHandle();
            int vl =0;
            //int vl = 1;
            if(vl > 8) {
              //  int ping = ep.ping;
                if(vl > 30) {
                    String color;
                /*    if(ping > 350) {
                        color = ChatColor.GOLD.toString();
                    } else {
                        color = ChatColor.RED.toString();
                    } */
                 //   sender.sendMessage(color+Online.getName()+ChatColor.GRAY+" -"+color+" ping:"+ping+ChatColor.GRAY+" -"+color+" vl:"+vl);
                } else {
                    String color = ChatColor.YELLOW.toString();
                  //  sender.sendMessage(color+Online.getName()+ChatColor.GRAY+" -"+color+" ping:"+ping+ChatColor.GRAY+" -"+color+" vl:"+vl);
                }

            }
        }

        sender.sendMessage(ChatColor.RED+"- --------------------- -");
        return true;
    }
}
