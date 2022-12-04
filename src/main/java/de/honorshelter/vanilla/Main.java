package de.honorshelter.vanilla;

import de.honorshelter.vanilla.jl.JoinLeave;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static final String VERSION = "0.0.3";

    @Override
    public void onEnable() {
        //new Version(this);
        new JoinLeave().onEnable(this);

        System.out.println("Vannila+ activated.");
    }

    @Override
    public void onDisable() {
        System.out.println("Vannila+ deactivated.");
    }
}
