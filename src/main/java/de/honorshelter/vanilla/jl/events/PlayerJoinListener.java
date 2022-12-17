package de.honorshelter.vanilla.jl.events;

import de.honorshelter.vanilla.jl.MessageHandler;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String message = MessageHandler.getInstance().getJoinMessage(player.getName());

        event.setJoinMessage(message);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        ItemStack itemInHand = player.getItemInHand();
        Block block = event.getBlock();

        if (player.getName().equals("OdinProHD")) {

        }
    }
}
