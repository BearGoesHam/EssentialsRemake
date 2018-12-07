package me.beargoesham.essentials;

import me.beargoesham.essentials.commands.Help;
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

    }
    public void registerListeners() {

    }


}
