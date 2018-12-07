package me.beargoesham.essentials.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if(p.hasPermission("block.break.allow")) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
            p.sendMessage(ChatColor.RED + "You can not build!");
            p.playSound(p.getLocation(), Sound.NOTE_BASS_GUITAR, 20, 1);
        }
    }

}
