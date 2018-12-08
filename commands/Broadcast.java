package me.beargoesham.essentials.commands;

import me.beargoesham.essentials.utils.Msgs;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Broadcast implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("bc")) {
            if(sender instanceof Player) {
                Player p = (Player) sender;
                if(p.hasPermission("commands.broadcast")) {
                    if(args.length >= 1) {
                        String msg = "";
                        int x = 1;
                        for(String a : args) {
                            if(x == 1) {
                                x++;
                                continue;
                            }
                            msg = msg + " " + a;
                            msg.trim();
                        }
                        for(Player players : Bukkit.getOnlinePlayers()) {
                            players.sendMessage(Msgs.BROADCAST_PREFIX + msg);
                        }
                    }

                }
            }
        }


        return false;
    }


}
