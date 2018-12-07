package me.beargoesham.essentials.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if(p.hasPermission("block.place.allow")) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
            p.sendMessage(ChatColor.RED + "You can not build!");
        }
    }

}
