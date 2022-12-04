package de.honorshelter.vanilla;

import de.honorshelter.vanilla.jl.JoinLeave;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        new JoinLeave().onEnable(this);

        System.out.println("Vannila+ activated.");
    }

    @Override
    public void onDisable() {
        System.out.println("Vannila+ deactivated.");
    }
}
