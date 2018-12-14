package me.beargoesham.essentials.commands;

import me.beargoesham.essentials.Main;
import me.beargoesham.essentials.file.FileManager;
import me.beargoesham.essentials.utils.Msgs;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class Report implements CommandExecutor
{

    Main main;
    FileManager manager;

    int id = 0;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if(cmd.getName().equalsIgnoreCase("report"))
        {
            if(sender instanceof Player) {
                Player p = (Player) sender;
                if (args.length >= 2) {
                    Player target = Bukkit.getServer().getPlayer(args[0]);
                    if (target == null) {
                        p.sendMessage(Msgs.INVALID_REPORT);
                    } else {
                        if (args.length >= 2) {
                            String reason = "";
                            int x = 2;
                            for (String a : args) {
                                if (x == 2) {
                                    x++;
                                    continue;
                                }
                                reason = reason + " " + a;
                                reason.trim();

                            }

                            String configPlayer = main.getConfig().getString("report.format");
                            String PlayerName = configPlayer.replace("%sender%", p.getName());
                            String TargetName = configPlayer.replace("%target%", target.getName());
                            String reason1 = configPlayer.replace("%reason%", reason);
                            String m1 = PlayerName + TargetName + reason1;
                            for (Player players : Bukkit.getServer().getOnlinePlayers()) {
                                players.sendMessage(m1);
                                id++;
                            }
                            File file = new File(main.getDataFolder() + "/reports.yml");
                            FileConfiguration configuration = YamlConfiguration.loadConfiguration(file);
                            String format;
                            format = p.getName() + "reported " + target.getName() + "for: " + m1;
                            configuration.set(Integer.toString(id), format);

                            if(args[0].equalsIgnoreCase("resolve"))
                            {
                            //int reportID = Integer.parseInt(args[0]);
                            int reportID = getID(args[0]);
                            if(reportID == id) {
                                if(configuration.isInt(Integer.toString(reportID))) {
                                    
                                }
                            }


                            }
                        }

                    }
                }

            }
        }


        return false;
    }
    public int getID(String string) {
        return this.id;
    }
}
