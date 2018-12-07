package me.beargoesham.essentials.commands;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Help implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("help")) {
            if(sender instanceof Player) {
                Player p = (Player) sender;

                TextComponent help = new TextComponent("List Of Commands");
                help.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("List Of Commands").create()));
                help.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, ""));
            }
        }


        return false;
    }

}
