package vn.teamgamervn.noadsinchat.data;

import org.bukkit.entity.Player;

import java.util.*;

public class PlayerManager {
    private final Map<UUID, List<Long>> playerData;
    public PlayerManager() {
        playerData = new HashMap<>();
    }
    public void initPlayer(Player player) {
        playerData.put(player.getUniqueId(), new ArrayList<>());
    }
    public void removePlayer(Player player) {
        playerData.remove(player.getUniqueId());
    }
    public boolean add(Player player) {
        List<Long> data = playerData.get(player.getUniqueId());
        data.add(System.currentTimeMillis());
        if (data.size() > Config.getSpamCount()) {
            data.remove(0);
            return data.get(data.size() - 1) - data.get(0) > Config.getSpamTime();
        }
        return false;
    }
}
