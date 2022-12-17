package de.honorshelter.vanilla.camera.events;

import io.papermc.paper.math.Rotations;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

public class BlockPlaceListener implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event){
        Player player = event.getPlayer();

        ItemStack item = event.getItemInHand();

        if(item.getType() != Material.PLAYER_HEAD){
            return;
        }

        if(!item.getItemMeta().getDisplayName().equals("Kamera")){
            return;
        }

        event.setCancelled(true);

        Location loc = event.getBlock().getLocation().subtract(0, 1, 0);
        Location center = getCenter(loc);

        ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
        head = Bukkit.getUnsafe().modifyItemStack(head, "{display:{Name:\"{\\\"Juckt?\\\":\\\"Junge kein Plan\\\"}\"},SkullOwner:{Id:[" + "I;-403550234,-1227534356,-1806171093,-608854317" + "],Properties:{textures:[{Value:\"" + "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2MzNmVjNTMyM2Y3NjVmZjU5ZjkxNmQyZDFhMWVjNzQ5Njg1NGNmN2JkMjZkZDJmMmNiYWRjM2RkNDkyNzljOCJ9fX0=" + "\"}]}}}");
        ItemMeta meta = head.getItemMeta();
        meta.setDisplayName("Kamera");
        head.setItemMeta(meta);
        head.setAmount(1);

        ArmorStand as = player.getWorld().spawn(center, ArmorStand.class);

        as.setArms(false);
        as.setBasePlate(false);
        as.setCanMove(false);
        as.setCanTick(false);
        as.setVisible(false);
        as.setInvulnerable(false);
        as.setItem(EquipmentSlot.HEAD, head);

        for(EquipmentSlot es : EquipmentSlot.values()){
            as.addDisabledSlots(es);
        }

        Vector vec = player.getLocation().toVector().subtract(as.getLocation().toVector());

        Location locdick = center.setDirection(vec);

        as.teleport(locdick);
    }

    public Location getCenter(Location loc) {
        return new Location(loc.getWorld(), loc.getBlockX() + .5, loc.getBlockY(), loc.getBlockZ() + .5);
    }
}
