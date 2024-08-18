package vn.teamgamervn.noadsinchat.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import vn.teamgamervn.noadsinchat.NoAdsInChat;
import vn.teamgamervn.noadsinchat.api.events.ChatBlockEvent;
import vn.teamgamervn.noadsinchat.data.Config;
import vn.teamgamervn.noadsinchat.data.NotifySetting;
import vn.teamgamervn.noadsinchat.tasks.Checker;

import java.net.InetAddress;
import java.util.Set;
import java.util.logging.Level;

public class ChatListener implements Listener {
    @EventHandler
    public void blacklistDetect(AsyncPlayerChatEvent event) {
        if (event.getPlayer().hasPermission("noads.bypass")) return;
        if (Checker.getChecker().checkMessage(event.getMessage()))
            cancel(event);
    }

    @EventHandler
    public void spamDetect(AsyncPlayerChatEvent event) {
        if (!Config.isSpamEnabled()) return;
        if (event.getPlayer().hasPermission("noads.bypass")) return;
        if (NoAdsInChat.getPlayerManager().add(event.getPlayer())) {
            cancel(event);
        }
    }

    public void cancel(AsyncPlayerChatEvent event) {
        // Call ChatBlockEvent
        ChatBlockEvent cbEvent = new ChatBlockEvent(event.getPlayer(), event.getMessage());
        Bukkit.getPluginManager().callEvent(cbEvent);
        if (event.isCancelled()) // If the blocking event is cancelled, we will not block the message
            return;

        Set<Player> recipients = event.getRecipients();
        event.getRecipients().removeAll(Bukkit.getOnlinePlayers());
        if (Config.isIPBlock()) {
            InetAddress address = event.getPlayer().getAddress().getAddress();
            for (Player player : recipients)
                if (player.getAddress().getAddress().equals(address))
                    event.getRecipients().add(player);
        } else {
            event.getRecipients().add(event.getPlayer());
        }
        event.getRecipients().add(event.getPlayer());
        Bukkit.getLogger().info("Player " + event.getPlayer().getName() + ": " + event.getMessage());
        NotifySetting.sendNotification(event.getPlayer(), event.getMessage());
    }
}
