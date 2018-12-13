package me.beargoesham.essentials.file;

import me.beargoesham.essentials.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

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

}
