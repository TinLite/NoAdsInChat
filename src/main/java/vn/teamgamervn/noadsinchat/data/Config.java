package vn.teamgamervn.noadsinchat.data;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class Config {
    private static FileConfiguration config;
    public static boolean PAPIStatus;
    private static Plugin plugin;
    public static String chatFormat;

    public static void loadConfig(Plugin p)
    {
        plugin = p;
        config = p.getConfig();
        if (config.getInt("config-version", -1) < 2) {
            p.getLogger().warning("Old-config detected. Please update config.yml with new-config.yml");
            File file = new File(p.getDataFolder(), "new-config.yml");
            try {
                if (file.createNewFile())
                    Files.copy(p.getResource("config.yml"), file.toPath());
            } catch (IOException e) {
                p.getLogger().warning("Error occurred while trying to save new configuration file.");
                e.printStackTrace();
            }
        }
        chatFormat = config.getString("default-chat-format");
    }

    public static void reloadConfig()
    {
        plugin.reloadConfig();
        config = plugin.getConfig();
        chatFormat = config.getString("default-chat-format");
    }

    public static List<String> getTriggers() {
        return config.getStringList("triggers");
    }

    public static String getNotifyFormat() {
        return config.getString("notify-format");
    }
}
