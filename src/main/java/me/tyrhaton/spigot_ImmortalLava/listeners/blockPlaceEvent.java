package me.tyrhaton.spigot_ImmortalLava.listeners;

import me.tyrhaton.spigot_ImmortalLava.Spigot_ImmortalLava;
import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class blockPlaceEvent implements Listener {

    private final Spigot_ImmortalLava plugin;

    public blockPlaceEvent(Spigot_ImmortalLava plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {

        if (event.isCancelled()) return;

        BlockState replacedState = event.getBlockReplacedState();
        System.out.println("[+] BlockPlaceEvent " + replacedState.getType());
        if (replacedState.getType().toString().equals("LAVA")) {
            event.setCancelled(true);
            event.getPlayer().sendMessage("[-] You cannot place blocks in immortal lava!");

        }
    }
}
