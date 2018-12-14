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


    //private String fileName;
    //private String path;
    ////private File file = new File(main.getDataFolder() + "/" + fileName + ".yml");
    public void createFile(String filename)
    {
        //this.fileName = filename;
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
        File file = new File(main.getDataFolder() + "/" + filename + ".yml");

        this.createFile(filename);

    }


    public File getFile(String filename)
    {
        File file = new File(main.getDataFolder() + "/" + filename + ".yml");
        return file;
    }


}
