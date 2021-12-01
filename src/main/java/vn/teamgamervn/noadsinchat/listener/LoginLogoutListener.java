package vn.teamgamervn.noadsinchat.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import vn.teamgamervn.noadsinchat.NoAdsInChat;
import vn.teamgamervn.noadsinchat.data.NotifySetting;

public class LoginLogoutListener implements Listener {
    public LoginLogoutListener() {

    }
    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        if (event.getPlayer().hasPermission("noads.notify.auto")) {
            NotifySetting.addNotify(event.getPlayer());
        }
        if (event.getPlayer().hasPermission("noads.bypass")) return;
        NoAdsInChat.getPlayerManager().initPlayer(event.getPlayer());
    }
    @EventHandler
    public void onLogout(PlayerQuitEvent event) {
        NotifySetting.removeNotify(event.getPlayer());
        NoAdsInChat.getPlayerManager().removePlayer(event.getPlayer());
    }
}
