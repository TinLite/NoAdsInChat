package vn.teamgamervn.noadsinchat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import vn.teamgamervn.noadsinchat.data.Config;
import vn.teamgamervn.noadsinchat.data.PlayerManager;
import vn.teamgamervn.noadsinchat.listener.ChatListener;
import vn.teamgamervn.noadsinchat.listener.LoginLogoutListener;

public final class NoAdsInChat extends JavaPlugin {
    private static NoAdsInChat instance;
    private static PlayerManager playerManager;
    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        Config.loadConfig(this);
        playerManager = new PlayerManager();
        for (Player player : Bukkit.getOnlinePlayers()) {
            playerManager.initPlayer(player);
        }
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
        Bukkit.getPluginManager().registerEvents(new LoginLogoutListener(), this);
        Config.PAPIStatus = true;
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null) {
            getLogger().warning("PlaceholderAPI is not installed. PlaceholderAPI-related functions will be disabled. Please consider install PlaceholderAPI.");
            Config.PAPIStatus = false;
        }
        this.getCommand("noadsinchat").setExecutor(new Commands());
        this.saveDefaultConfig();
    }

    public static NoAdsInChat getInstance() {
        return instance;
    }

    public static PlayerManager getPlayerManager() {
        return playerManager;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
