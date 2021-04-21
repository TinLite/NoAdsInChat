package vn.teamgamervn.noadsinchat.data;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

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
}
