package me.beargoesham.essentials.staff;

import me.beargoesham.essentials.Main;
import me.beargoesham.essentials.utils.Msgs;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffChat implements CommandExecutor {

    Main main;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if(cmd.getName().equalsIgnoreCase("sc"))
        {
            if(sender instanceof Player)
            {
                Player p = (Player) sender;
                if(p.hasPermission("staff.chat.use"))
                {
                    if(args.length >= 1)
                    {
                        int x = 1;
                        String msg = "";
                        for(String a : args)
                        {
                            if(x == 1)
                            {
                                x++;
                                continue;
                            }
                            msg = msg + " " + a;
                            msg.trim();

                        }
                        String message = main.getConfig().getString("staffchat.format");
                        String m1 = message.replace("%message%", msg);
                        for(Player players : Bukkit.getOnlinePlayers())
                        {
                            if(players.hasPermission("staff.chat.use"))
                            {
                                players.sendMessage(m1);
                            }
                        }
                        }
                    }
                }
            }

        return false;
    }

}
