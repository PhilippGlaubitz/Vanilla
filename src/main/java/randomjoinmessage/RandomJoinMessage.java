package randomjoinmessage;

import me.blackphoenix.randomjoinmessage.listeners.JoinLeaveListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class RandomJoinMessage extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
