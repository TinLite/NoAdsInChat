package vn.teamgamervn.noadsinchat.hooks;

import github.scarsz.discordsrv.api.Subscribe;
import github.scarsz.discordsrv.api.events.GameChatMessagePreProcessEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import vn.teamgamervn.noadsinchat.api.events.ChatBlockEvent;

import java.util.HashSet;
import java.util.UUID;

public class DiscordSRVHook implements Listener {
    // Thanks DiscordSRV for having yet another event system that works exactly like Bukkit one although it could only work on Bukkit. Love you <3
    private final HashSet<UUID> blockedPlayerSet;

    public DiscordSRVHook() {
        blockedPlayerSet = new HashSet<>();
    }

    public void addBlock(UUID uuid) {
        blockedPlayerSet.add(uuid);
    }

    public void addBlock(Player player) {
        addBlock(player.getUniqueId());
    }

    public void removeBlock(UUID uuid) {
        blockedPlayerSet.remove(uuid);
    }

    public void removeBlock(Player player) {
        removeBlock(player.getUniqueId());
    }

    public boolean isBlocked(UUID uuid) {
        return blockedPlayerSet.contains(uuid);
    }

    public boolean isBlocked(Player player) {
        return isBlocked(player.getUniqueId());
    }

    @EventHandler
    public void onBlock(ChatBlockEvent event) {
        addBlock(event.getPlayer());
    }

    @Subscribe
    public void onMessagePreProcess(GameChatMessagePreProcessEvent event) {
        if (isBlocked(event.getPlayer())) {
            removeBlock(event.getPlayer());
            event.setCancelled(true);
        }
    }

    // Just to be safe
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        removeBlock(event.getPlayer());
    }
}
