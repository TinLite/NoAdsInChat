package vn.teamgamervn.noadsinchat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import vn.teamgamervn.noadsinchat.data.Config;
import vn.teamgamervn.noadsinchat.data.NotifySetting;

import java.util.Locale;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sendHelp(sender);
            return true;
        }
        if (args[0].equalsIgnoreCase("reload") && sender.hasPermission("noads.admin")) {
            Config.reloadConfig();
            return true;
        }
        if (args[0].equalsIgnoreCase("notify") && sender.hasPermission("noads.notify")) {
            if (args.length == 1)
                return sendHelp(sender);
            if (args.length == 2 && !(sender instanceof Player)) {
                sender.sendMessage("Player-only command");
                return true;
            }
            Player target;
            if (args.length != 3)
                target = (Player) sender;
            else {
                target = Bukkit.getPlayerExact(args[2]);
                if (target == null) {
                    sender.sendMessage("&c&lPlayer not found");
                    return true;
                }
            }
            switch (args[1].toLowerCase(Locale.ROOT)) {
                case "on":
                    NotifySetting.addNotify(target);
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aNAID Notification: &e&lON"));
                    return true;
                case "off":
                    NotifySetting.removeNotify(target);
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aNAID Notification: &e&lOFF"));
                    return true;
                default:
                    return sendHelp(sender);
            }
        }
        return sendHelp(sender);
    }

    public boolean sendHelp(CommandSender sender) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eNoAdsInChat &fv" + NoAdsInChat.getInstance().getDescription().getVersion() + " by &cVinhGaming"));
        if (sender.hasPermission("noads.admin"))
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "[&eNoAdsInChat&f] /noads reload - Reload Plugin"));
        if (sender.hasPermission("noads.notify"))
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "[&eNoAdsInChat&f] /noads notify <on/off> [Player] - Enable/Disable notification"));
        return true;
    }
}
