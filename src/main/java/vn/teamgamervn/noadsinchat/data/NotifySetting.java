package vn.teamgamervn.noadsinchat.data;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.*;

public class NotifySetting {
    private static final Set<Player> notify = new HashSet<>();
    public static void addNotify(Player player) {
        notify.add(player);
    }
    public static void removeNotify(Player player) {
        notify.remove(player);
    }
    public static void sendNotification(Player player, String message) {
        String content = Config.getNotifyFormat().replaceAll("%player%", player.getName());
        content = ChatColor.translateAlternateColorCodes('&', content);
        content = content.replaceAll("%message%", message);
        for (Player target : notify)
            target.sendMessage(content);
    }
}
