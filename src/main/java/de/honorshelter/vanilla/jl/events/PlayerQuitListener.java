package de.honorshelter.vanilla.jl.events;

import de.honorshelter.vanilla.jl.MessageHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        String message = MessageHandler.getInstance().getLeaveMessage(player.getName());

        event.setQuitMessage(message);
    }

}
