package lc.core.Commands;

import lc.core.Controller.Database;
import lc.core.Controller.Jugador;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WhitelistByPass implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            sender.sendMessage(ChatColor.RED + "No puede ejecutar este comando.");
            return false;
        }
        if(args.length <=1){
            sender.sendMessage(ChatColor.RED + "usa /setbypass <Player> <true/false>");
            return false;
        }
        String player = args[0];
        String valor = args[1];
        Jugador jug = Jugador.getJugador(player);
        jug.hasWhitelistBypass(Boolean.parseBoolean(valor));
        Database.saveWhitelistPlayer(jug);


        return true;
    }
}
