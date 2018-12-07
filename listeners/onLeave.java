package me.beargoesham.essentials.listeners;

import me.beargoesham.essentials.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class onLeave implements Listener {

    Main main;

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        String msg = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("leavemsg"));
        String m1 = msg.replace(main.getConfig().getString("%player_name%"), p.getName());
        for(Player players : Bukkit.getServer().getOnlinePlayers()) {
            players.sendMessage(m1);
        }
    }

}
