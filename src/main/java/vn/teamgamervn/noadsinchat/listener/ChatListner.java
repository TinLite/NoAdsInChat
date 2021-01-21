package vn.teamgamervn.noadsinchat.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListner implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        // Làm gì cũng phải getPlayer trước đã
        Player player = event.getPlayer();


    }
}
