package me.tyrhaton.spigot_ImmortalLava.listeners;

import me.tyrhaton.spigot_ImmortalLava.Spigot_ImmortalLava;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;

public class bucketEmptyEvent implements Listener {

    private final Spigot_ImmortalLava plugin;

    public bucketEmptyEvent(Spigot_ImmortalLava plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBucketEmpty(PlayerBucketEmptyEvent event) {
        if (event.isCancelled()) return;

        Block clickedBlock = event.getBlockClicked();
        // Determine the block where water would be placed based on the face clicked
        Block targetBlock = clickedBlock.getRelative(event.getBlockFace());

        // If the target block is lava, cancel the event
        if (targetBlock.getType() == Material.LAVA) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.DARK_RED + "[-] You cannot place water in " + ChatColor.ITALIC +"Immortal lava!");
        }
    }
}


