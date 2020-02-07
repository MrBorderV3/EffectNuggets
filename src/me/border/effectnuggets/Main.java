package me.border.effectnuggets;

import me.border.effectnuggets.commands.Commandeffectnugget;
import me.border.effectnuggets.listeners.EffectnuggetsEvents;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable() {
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        new Commandeffectnugget(this);
        getServer().getPluginManager().registerEvents(new EffectnuggetsEvents(this), this);
    }
}
