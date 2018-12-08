package me.beargoesham.essentials.commands;

import me.beargoesham.essentials.utils.Msgs;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffHelp implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("shelp")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                String msg = "";
                if(args.length >= 1) {
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
                        if(players.hasPermission("staff.help.see")) {
                            players.sendMessage(ChatColor.translateAlternateColorCodes('&', Msgs.HELPOP_PREFX + msg));
                        }
                    }
                }
            }
        }


        return false;
    }

}
