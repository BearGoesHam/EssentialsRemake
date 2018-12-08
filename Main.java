package me.beargoesham.essentials;

import me.beargoesham.essentials.commands.Broadcast;
import me.beargoesham.essentials.commands.Help;
import me.beargoesham.essentials.listeners.BlockBreakListener;
import me.beargoesham.essentials.listeners.BlockPlaceListener;
import me.beargoesham.essentials.listeners.onJoin;
import me.beargoesham.essentials.listeners.onLeave;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable() {

        registerCommands();
        registerListeners();

    }
    public void onDisable() {



    }
    public void registerCommands() {

        getCommand("help").setExecutor(new Help());
        getCommand("bc").setExecutor(new Broadcast());

    }
    public void registerListeners() {

        PluginManager manager = Bukkit.getServer().getPluginManager();
        manager.registerEvents(new onJoin(), this);
        manager.registerEvents(new onLeave(), this);
        manager.registerEvents(new BlockPlaceListener(), this);
        manager.registerEvents(new BlockBreakListener(), this);

    }


}
