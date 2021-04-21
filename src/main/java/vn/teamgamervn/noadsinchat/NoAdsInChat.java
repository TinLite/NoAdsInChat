package vn.teamgamervn.noadsinchat;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import vn.teamgamervn.noadsinchat.data.Config;
import vn.teamgamervn.noadsinchat.listener.ChatListner;

public final class NoAdsInChat extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new ChatListner(), this);
        Config.PAPIStatus = true;
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null) {
            getLogger().warning("PlaceholderAPI is not installed. PlaceholderAPI-related functions will be disabled. Please consider install PlaceholderAPI.");
            Config.PAPIStatus = false;
        }
        this.getCommand("noadsinchat").setExecutor(new Commands());
        this.saveDefaultConfig();
        Config.loadConfig(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
