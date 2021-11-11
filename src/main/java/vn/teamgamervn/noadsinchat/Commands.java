package vn.teamgamervn.noadsinchat;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import vn.teamgamervn.noadsinchat.data.Config;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("noads.admin"))
            return true;
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eNoAdsInChat &fv" + NoAdsInChat.getInstance().getDescription().getVersion() + " by &cVinhGaming"));
        if (args.length == 0) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "[&eNoAdsInChat&f] /noads reload - Reload Plugin"));
            return true;
        }
        if (args[0].equalsIgnoreCase("reload"))
            Config.reloadConfig();
        return true;
    }
}
