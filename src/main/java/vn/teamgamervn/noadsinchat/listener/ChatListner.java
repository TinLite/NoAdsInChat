package vn.teamgamervn.noadsinchat.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import vn.teamgamervn.noadsinchat.data.Config;
import vn.teamgamervn.noadsinchat.util.Checker;
import vn.teamgamervn.noadsinchat.util.PAPIStringBuilder;

import java.util.logging.Level;

public class ChatListner implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        if (event.getPlayer().hasPermission("noads.bypass")) return;
        for (String s : Config.getTriggers()) {
                if (new Checker().checkRegex(event.getMessage(), s))
                {
                    event.setCancelled(true);
                    event.getPlayer().sendMessage(new PAPIStringBuilder().getChat(event.getMessage(), event.getPlayer()));
                    Bukkit.getLogger().log(Level.INFO, "[NoAdsInChat] Player " + event.getPlayer().getName() + ": " + event.getMessage());
                    return;
                }
        }
    }
}
