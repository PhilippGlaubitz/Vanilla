package de.honorshelter.vanilla;

import de.honorshelter.vanilla.jl.JoinLeave;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        new JoinLeave().onEnable(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
