package me.tyrhaton.spigot_ImmortalLava.listeners;

import me.tyrhaton.spigot_ImmortalLava.Spigot_ImmortalLava;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

import java.util.Objects;

public class entityChangeBlockEvent implements Listener {

    private final Spigot_ImmortalLava plugin;

    public entityChangeBlockEvent(Spigot_ImmortalLava plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onEntityChangeBlock(EntityChangeBlockEvent event) {
        if (event.isCancelled()) return;

        if (event.getEntity() instanceof FallingBlock fallingBlock) {
            Location loc = fallingBlock.getLocation();
            Block blockAtLocation = loc.getBlock();

            // Check if the block at the falling block's current location is lava
            if (blockAtLocation.getType() == Material.LAVA) {
                event.setCancelled(true);
                // Remove the falling block entity directly
                fallingBlock.remove();
                // Optionally, spawn flame particles for a burning effect
                Objects.requireNonNull(loc.getWorld()).spawnParticle(Particle.FLAME, loc, 10);
            }
        }
    }
}
