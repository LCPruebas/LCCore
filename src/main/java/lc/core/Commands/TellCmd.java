package lc.core.Commands;

import lc.core.CoreMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TellCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String arg, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player)sender;
            if (args.length == 0) {
                p.sendMessage(ChatColor.GREEN + "Envia un mensaje usando: /tell <jugador> <mensaje>!");
            } else if (args.length == 1) {
                p.sendMessage(ChatColor.GREEN + "Escribe un mensaje.");
            } else {
                Player r = Bukkit.getPlayer(args[0]);
                String msg = getMsg(args);

                if (args[0].equalsIgnoreCase("server")) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&l[&8Yo&4&l - &8Server&4&l]&f" + msg));
                    Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&l[&f" + p.getName() + " &4&l- &fServer&4&l]&f" + msg));
                } else if (r == null || !r.isOnline()) {
                    p.sendMessage(ChatColor.RED + "El jugador " + args[0] + " no esta conectado!");
                } else if (p.getName() == r.getName()) {
                    p.sendMessage(ChatColor.RED + "No puedes enviarte un mensaje a ti mismo.");
                } else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l(&cYo&3&l &8&m&l-&8&l> &c" + r.getName() + "&8&l)&f" + msg));
                    r.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l(&c" + p.getName() + "&8&m&l-&8&l> &cYo&8&l)&f" + msg));
                    CoreMain.getInstance().setReplyPlayer(p, r);
                }

            }
        } else if (args.length == 0) {
            sender.sendMessage(ChatColor.GRAY + "usa:" + ChatColor.GREEN + "/tell <jugador> <mensaje>!");
        } else if (args.length == 1) {
            sender.sendMessage(ChatColor.DARK_GRAY + "Escribe un mensaje.");
        } else {
            Player r = Bukkit.getPlayer(args[0]);
            String msg = getMsg(args);

            if (r == null || !r.isOnline()) {
                sender.sendMessage(ChatColor.RED + "El jugador " + args[0] + " no esta conectado!");
            } else {

                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&l[&8Server&4&l - &f" + r.getName() + "&4&l]&f" + msg));
                r.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&l[&8Server &4&l - &8Yo&4&l]&f" + msg));


            }
        }

        return true;
    }


    private String getMsg(String[] args) {
        String ret = "";
        for (int n = 1; n < args.length; n++) {
            ret = String.valueOf(String.valueOf(ret)) + " " + args[n];
        }
        return ret;
    }
}
