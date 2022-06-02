package vn.teamgamervn.noadsinchat;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import vn.teamgamervn.noadsinchat.data.Config;
import vn.teamgamervn.noadsinchat.data.PlayerManager;
import vn.teamgamervn.noadsinchat.listener.ChatListener;
import vn.teamgamervn.noadsinchat.listener.LoginLogoutListener;
import vn.teamgamervn.noadsinchat.util.Checker;

public final class NoAdsInChat extends JavaPlugin {
    private static NoAdsInChat instance;
    private static PlayerManager playerManager;
    private static Checker checker;

    public static Checker getChecker() {
        return checker;
    }

    public static NoAdsInChat getInstance() {
        return instance;
    }

    public static PlayerManager getPlayerManager() {
        return playerManager;
    }

    public static void setPlayerManager(PlayerManager playerManager) {
        NoAdsInChat.playerManager = playerManager;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        this.saveDefaultConfig();
        Config.loadConfig();
        checker = new Checker();
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
        Bukkit.getPluginManager().registerEvents(new LoginLogoutListener(), this);
        this.getCommand("noadsinchat").setExecutor(new Commands());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
