package me.tyrhaton.spigot_ImmortalLava.listeners;

import me.tyrhaton.spigot_ImmortalLava.Spigot_ImmortalLava;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.event.block.BlockFromToEvent;

public class blockSpreadEvent implements Listener {

    private final Spigot_ImmortalLava plugin;

    public blockSpreadEvent(Spigot_ImmortalLava plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockFromTo(BlockFromToEvent event) {
        if (event.isCancelled()) return;

        Block fromBlock = event.getBlock();
        Block toBlock = event.getToBlock();

        // If water is flowing into a block that is lava, cancel the event.
        if (fromBlock.getType() == Material.WATER && toBlock.getType() == Material.LAVA) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockSpread(BlockFormEvent event) {
        if (event.isCancelled()) return;

        Block block = event.getBlock();
        BlockState newState = event.getNewState();

        if (block.getType() == Material.LAVA) {
            Material newMaterial = newState.getType();

            // Check if the new block type is one of the forms you want to prevent
            if (newMaterial == Material.STONE ||
                    newMaterial == Material.COBBLESTONE ||
                    newMaterial == Material.OBSIDIAN) {
                event.setCancelled(true);
            }
        }
    }
}
