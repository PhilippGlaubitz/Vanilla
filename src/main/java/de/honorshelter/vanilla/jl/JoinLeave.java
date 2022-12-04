package de.honorshelter.vanilla.jl;

import de.honorshelter.vanilla.Function;
import de.honorshelter.vanilla.Main;
import de.honorshelter.vanilla.jl.events.PlayerJoinListener;
import de.honorshelter.vanilla.jl.events.PlayerQuitListener;

public class JoinLeave implements Function {

    @Override
    public void onEnable(Main main) {
        new MessageHandler();

        main.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), main);
        main.getServer().getPluginManager().registerEvents(new PlayerQuitListener(), main);
    }
}
