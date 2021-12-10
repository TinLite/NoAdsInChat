package vn.teamgamervn.noadsinchat.data;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import vn.teamgamervn.noadsinchat.NoAdsInChat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class Config {
    private static FileConfiguration config;
    private static final int VERSION = 3;

    public static void loadConfig() {
        NoAdsInChat p = NoAdsInChat.getInstance();
        config = p.getConfig();
        if (config.getInt("config-version", -1) < VERSION) {
            p.getLogger().warning("Old-config detected. Please update config.yml with new-config.yml");
            File file = new File(p.getDataFolder(), "new-config.yml");
            try {
                if (file.createNewFile())
                    Files.copy(p.getResource("config.yml"), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                p.getLogger().warning("Error occurred while trying to save new configuration file.");
                e.printStackTrace();
            }
        }
    }

    public static void reloadConfig() {
        NoAdsInChat plugin = NoAdsInChat.getInstance();
        plugin.reloadConfig();
        config = plugin.getConfig();
        if (Config.isSpamEnabled()) {
            NoAdsInChat.setPlayerManager(new PlayerManager());
            for (Player player : Bukkit.getOnlinePlayers()) {
                NoAdsInChat.getPlayerManager().initPlayer(player);
            }
        }
        NoAdsInChat.getChecker().loadChecker();
    }

    public static List<String> getTriggers() {
        return config.getStringList("BlacklistDetection.triggers");
    }

    public static String getNotifyFormat() {
        return config.getString("Locale.notify-format");
    }

    public static int getSpamCount() {
        return config.getInt("SpamDetection.Count");
    }

    public static int getSpamTime() {
        return config.getInt("SpamDetection.Time");
    }

    public static boolean isRegexEnabled() {
        return config.getBoolean("BlacklistDetection.enableRegex", true);
    }

    public static boolean isSpamEnabled() {
        return config.getBoolean("SpamDetection.Enabled");
    }

    public static boolean isIPBlock() {
        return config.getBoolean("GlobalSettings.IPWideBlock");
    }
}
