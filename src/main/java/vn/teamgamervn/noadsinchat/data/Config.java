package vn.teamgamervn.noadsinchat.data;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class Config {
    static FileConfiguration config;
    public static boolean PAPIStatus;

    public static void loadConfig(FileConfiguration configuration) {
        config = configuration;
    }

    public static List<String> getTriggers() {
        return config.getStringList("Triggers");
    }
}
