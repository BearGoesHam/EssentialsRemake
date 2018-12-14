package me.beargoesham.essentials.utils;

import me.beargoesham.essentials.Main;
import me.beargoesham.essentials.file.FileManager;
import org.bukkit.ChatColor;

public class Msgs {

    FileManager manager;
    static Main main;

    public static final String BROADCAST_PREFIX = ChatColor.translateAlternateColorCodes('&', "&4[Broadcast] ");
    public static final String HELPOP_PREFX = ChatColor.translateAlternateColorCodes('&', "&4[Help] ");
    public static final String INVALID = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("noperm"));
    public static final String INVALID_REPORT = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("reportinvalid"));
    //public static  final String STAFFCHAT_PREFIX = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("staffchat.prefix"));


}
