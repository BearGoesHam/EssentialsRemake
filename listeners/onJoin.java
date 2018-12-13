package me.beargoesham.essentials.listeners;

import me.beargoesham.essentials.Main;
import me.beargoesham.essentials.file.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoin implements Listener {

    Main plugin;
    FileManager manager;

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        String msg = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("joinmsg"));
        String m1 = msg.replace(plugin.getConfig().getString("%player_name%"), p.getName());
        for(Player players : Bukkit.getServer().getOnlinePlayers()) {
            players.sendMessage(m1);
        }
        try
        {
            manager.createPlayerFile(p);
        } catch(Exception exception)
        {
         exception.printStackTrace();
        }


    }

}
