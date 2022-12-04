package de.honorshelter.vanilla.jl.events;

import de.honorshelter.vanilla.jl.MessageHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String message = MessageHandler.getInstance().getJoinMessage(player.getName());

        event.setJoinMessage(message);
    }

}
