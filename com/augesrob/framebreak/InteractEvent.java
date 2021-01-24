package com.augesrob.framebreak;

import java.util.Objects;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class InteractEvent implements Listener {
    private FileConfiguration config;
    private BlockFace[] portals;

    public InteractEvent(FrameBreak e) {
        this.portals = new BlockFace[]{BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST};
        this.config = e.getConfig();
    }

    private void checkFace(int i, Block b) {
        Block currentFace = b.getRelative(this.portals[i]);
        if (currentFace.getType().equals(Material.END_PORTAL_FRAME)) {
            currentFace.breakNaturally();

            for(int x = 0; x < 4; ++x) {
                this.checkFace(x, currentFace);
            }
        }

    }

    @EventHandler(
        ignoreCancelled = true
    )
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("framebreak.break") && ((ItemStack)Objects.requireNonNull(event.getItem())).getType().toString().equals(this.config.getString("tool")) && event.getAction() == Action.LEFT_CLICK_BLOCK && ((Block)Objects.requireNonNull(event.getClickedBlock())).getType().equals(Material.END_PORTAL_FRAME) && player.getGameMode().equals(GameMode.SURVIVAL)) {
            event.setCancelled(true);
            event.getClickedBlock().setType(Material.AIR);

            for(int i = 0; i < 4; ++i) {
                this.checkFace(i, event.getClickedBlock());
            }

            event.getClickedBlock().getWorld().dropItemNaturally(event.getClickedBlock().getLocation(), new ItemStack(Material.END_PORTAL_FRAME));
        }

    }
}
