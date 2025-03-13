package me.tyrhaton.spigot_ImmortalLava.listeners;

import me.tyrhaton.spigot_ImmortalLava.Spigot_ImmortalLava;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketFillEvent;

public class bucketFillEvent implements Listener {

    private final Spigot_ImmortalLava plugin;

    public bucketFillEvent(Spigot_ImmortalLava plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onBucketFill(PlayerBucketFillEvent event) {
        if (event.isCancelled()) return;

        Block clickedBlock = event.getBlockClicked();
        if (clickedBlock.getType() == Material.LAVA) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.DARK_RED + "[-] You cannot pick up " + ChatColor.ITALIC +"Immortal lava!");
        }
    }

}
