package de.honorshelter.vanilla.camera;

import de.honorshelter.vanilla.Function;
import de.honorshelter.vanilla.Main;
import de.honorshelter.vanilla.camera.events.BlockPlaceListener;
import de.honorshelter.vanilla.camera.events.EntityDamageByEntityListener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.UUID;

public class Camera implements Function {


    @Override
    public void onEnable(Main main) {
        main.getServer().getPluginManager().registerEvents(new BlockPlaceListener(), main);
        main.getServer().getPluginManager().registerEvents(new EntityDamageByEntityListener(), main);

        Player player = Bukkit.getPlayer("OdinProHD");

        if(player == null){
            return;
        }

        if(!player.isOnline()){
            return;
        }

        ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
        head = Bukkit.getUnsafe().modifyItemStack(head, "{display:{Name:\"{\\\"Juckt?\\\":\\\"Junge kein Plan\\\"}\"},SkullOwner:{Id:[" + "I;-403550234,-1227534356,-1806171093,-608854317" + "],Properties:{textures:[{Value:\"" + "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2MzNmVjNTMyM2Y3NjVmZjU5ZjkxNmQyZDFhMWVjNzQ5Njg1NGNmN2JkMjZkZDJmMmNiYWRjM2RkNDkyNzljOCJ9fX0=" + "\"}]}}}");
        ItemMeta meta = head.getItemMeta();
        meta.setDisplayName("Kamera");
        head.setItemMeta(meta);

        //player.getInventory().addItem(head);
    }
}
