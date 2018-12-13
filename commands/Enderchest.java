package me.beargoesham.essentials.commands;

import me.beargoesham.essentials.utils.Msgs;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Enderchest implements CommandExecutor
{

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if(cmd.getName().equalsIgnoreCase("enderchest"))
        {
            if(sender instanceof Player)
            {
                Player p = (Player) sender;
                if(p.hasPermission("command.enderchest"))
                {
                    Inventory inventory = p.getEnderChest();
                    p.openInventory(inventory);
                } else
                {
                    p.sendMessage(Msgs.INVALID);
                }
            } else
            {
                System.out.println("You can not use this.");
            }
        }

        return false;
    }

}
