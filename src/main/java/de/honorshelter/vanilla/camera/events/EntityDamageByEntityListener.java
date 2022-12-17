package de.honorshelter.vanilla.camera.events;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class EntityDamageByEntityListener implements Listener{

    @EventHandler
    public void damage(EntityDamageByEntityEvent event){

        if(!(event.getEntity() instanceof Player)){
            return;
        }

        if(!(event.getDamager() instanceof Player)){
            return;
        }

        Player damaged = (Player) event.getEntity();
        Player damager = (Player) event.getDamager();

        ItemStack item = damager.getInventory().getItemInMainHand();

        if(item.getType() != Material.STICK){
            return;
        }

        if(item.getItemMeta().getDisplayName().equals("Ehrenstick")){

            Vector dir = damaged.getLocation().getDirection();
            dir = dir.setY(0);
            dir = dir.multiply(50);

            damaged.setVelocity(dir);
        }

        if(item.getItemMeta().getDisplayName().equals("Ultimativer Stick")){
            Vector dir = damaged.getLocation().getDirection();
            dir = dir.setY(0);
            dir = dir.multiply(100);

            damaged.setVelocity(dir);
        }
    }
}
