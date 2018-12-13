package me.beargoesham.essentials.file;

import me.beargoesham.essentials.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileManager {

    Main main;

    public void createFile(String filename)
    {
        File customYml = new File(main.getDataFolder() + "/" + filename + ".yml");
        FileConfiguration customConfig = YamlConfiguration.loadConfiguration(customYml);

    }

    public void saveCustomYml(FileConfiguration ymlConfig, File ymlFile)
    {
        try {
            ymlConfig.save(ymlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void createPlayerFile(Player player)
    {
        UUID uuid = player.getUniqueId();
        String filename = uuid.toString();
        this.createFile(filename);

    }


}
