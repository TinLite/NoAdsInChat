package vn.teamgamervn.noadsinchat.util;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import vn.teamgamervn.noadsinchat.data.Config;

public class PAPIStringBuilder {
    public String getChat(String chat, Player player)
    {
        String output = Config.chatFormat;
        if (Config.PAPIStatus)
            output = PlaceholderAPI.setPlaceholders(player, output);
        output = ChatColor.translateAlternateColorCodes('&', output);
        return output.replace("{chat}", chat);
    }
}
