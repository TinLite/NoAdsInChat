package vn.teamgamervn.noadsinchat.util;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import vn.teamgamervn.noadsinchat.data.Config;

public class PAPIStringBuilder {
    public String getChat(String string, Player player)
    {
        if (Config.PAPIStatus)
            string = PlaceholderAPI.setPlaceholders(player, string);
        string = ChatColor.translateAlternateColorCodes('&', string);
        return string.replace("{chat}", string);
    }
}
