package vn.teamgamervn.noadsinchat.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import vn.teamgamervn.noadsinchat.data.Config;
import vn.teamgamervn.noadsinchat.util.Checker;
import vn.teamgamervn.noadsinchat.util.PAPIStringBuilder;

public class ChatListner implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {

        for (String s : Config.getTriggers()) {
            String[] temp = s.split(":", 2);
            if (temp[0].equalsIgnoreCase("regex"))
            {
                if (new Checker().checkRegex(event.getMessage(), temp[1]))
                {
                    event.setCancelled(true);
                    event.getPlayer().sendMessage(new PAPIStringBuilder().getChat(event.getMessage(), event.getPlayer()));
                    return;
                }
                continue;
            }
            if (temp[0].equalsIgnoreCase("text"))
            {
                if (new Checker().checkText(event.getMessage(), temp[1]))
                {
                    event.setCancelled(true);
                    event.getPlayer().sendMessage(new PAPIStringBuilder().getChat(event.getMessage(), event.getPlayer()));
                    return;
                }
            }
        }
    }
}
