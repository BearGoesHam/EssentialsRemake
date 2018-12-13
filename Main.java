package me.beargoesham.essentials;

import me.beargoesham.essentials.commands.Broadcast;
import me.beargoesham.essentials.commands.Help;
import me.beargoesham.essentials.commands.StaffHelp;
import me.beargoesham.essentials.file.FileManager;
import me.beargoesham.essentials.listeners.BlockBreakListener;
import me.beargoesham.essentials.listeners.BlockPlaceListener;
import me.beargoesham.essentials.listeners.onJoin;
import me.beargoesham.essentials.listeners.onLeave;
import me.beargoesham.essentials.staff.StaffChat;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    FileManager fileManager;

    public void onEnable() {

        registerCommands();
        registerListeners();

        this.getConfig().options().copyDefaults(true);
        saveConfig();

    }
    public void onDisable() {



    }
    public void registerCommands() {

        getCommand("help").setExecutor(new Help());
        getCommand("bc").setExecutor(new Broadcast());
        getCommand("sc").setExecutor(new StaffChat());
        getCommand("helpop").setExecutor(new StaffHelp());

    }
    public void registerListeners() {

        PluginManager manager = Bukkit.getServer().getPluginManager();
        manager.registerEvents(new onJoin(), this);
        manager.registerEvents(new onLeave(), this);
        manager.registerEvents(new BlockPlaceListener(), this);
        manager.registerEvents(new BlockBreakListener(), this);

    }


}
