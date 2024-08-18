package vn.teamgamervn.noadsinchat;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import vn.teamgamervn.noadsinchat.data.Config;
import vn.teamgamervn.noadsinchat.data.PlayerManager;
import vn.teamgamervn.noadsinchat.hooks.DiscordSRVHook;
import vn.teamgamervn.noadsinchat.listeners.ChatListener;
import vn.teamgamervn.noadsinchat.listeners.LoginLogoutListener;
import vn.teamgamervn.noadsinchat.tasks.Checker;

public final class NoAdsInChat extends JavaPlugin {
    private static PlayerManager playerManager;

    public static PlayerManager getPlayerManager() {
        return playerManager;
    }

    public static void setPlayerManager(PlayerManager playerManager) {
        NoAdsInChat.playerManager = playerManager;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.saveDefaultConfig();
        Config.loadConfig();
        Checker.getChecker(); // This will load checker
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
        Bukkit.getPluginManager().registerEvents(new LoginLogoutListener(), this);

        // DiscordSRV
        if (Bukkit.getPluginManager().getPlugin("DiscordSRV") != null) {
            DiscordSRVHook discordSRVHook = new DiscordSRVHook();
            Bukkit.getPluginManager().registerEvents(discordSRVHook, this); // Bukkit event handler
            github.scarsz.discordsrv.DiscordSRV.api.subscribe(discordSRVHook);    // DiscordSRV event handler
            this.getLogger().info("DiscordSRV detected. Hook enabled.");
        }

        this.getCommand("noadsinchat").setExecutor(new Commands());
    }
}
