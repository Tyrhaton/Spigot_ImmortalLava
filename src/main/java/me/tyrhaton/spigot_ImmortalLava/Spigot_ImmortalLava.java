package me.tyrhaton.spigot_ImmortalLava;

import me.tyrhaton.spigot_ImmortalLava.listeners.blockPlaceEvent;
import me.tyrhaton.spigot_ImmortalLava.listeners.bucketFillEvent;
import me.tyrhaton.spigot_ImmortalLava.listeners.entityChangeBlockEvent;
import org.bukkit.plugin.java.JavaPlugin;


public final class Spigot_ImmortalLava extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        System.out.println("[+] Unsupported Falls plugin started");

        this.saveDefaultConfig(); //saves the default config.yml

        getServer().getPluginManager().registerEvents(new blockPlaceEvent(this), this);
        getServer().getPluginManager().registerEvents(new bucketFillEvent(this), this);
        getServer().getPluginManager().registerEvents(new entityChangeBlockEvent(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
