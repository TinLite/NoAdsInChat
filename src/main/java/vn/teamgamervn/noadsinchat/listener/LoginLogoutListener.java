package vn.teamgamervn.noadsinchat.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import vn.teamgamervn.noadsinchat.data.NotifySetting;

public class LoginLogoutListener implements Listener {
    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        if (event.getPlayer().hasPermission("noads.notify.auto")) {
            NotifySetting.addNotify(event.getPlayer());
        }
    }
    @EventHandler
    public void onLogout(PlayerQuitEvent event) {
        NotifySetting.removeNotify(event.getPlayer());
    }
}
