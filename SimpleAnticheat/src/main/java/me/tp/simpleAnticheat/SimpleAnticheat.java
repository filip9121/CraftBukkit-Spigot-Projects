package com.yourname.simpleanticheat;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public final class SimpleAntiCheat extends JavaPlugin implements Listener {

    private final double MAX_ALLOWED_SPEED = 0.8; // The speed limit

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("SimpleAntiCheat enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("SimpleAntiCheat disabled.");
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location from = event.getFrom();
        Location to = event.getTo();

        // Ignore vertical movement (jumping/falling)
        Vector fromVector = new Vector(from.getX(), 0, from.getZ());
        Vector toVector = new Vector(to.getX(), 0, to.getZ());

        double distanceMoved = fromVector.distance(toVector);

        if (distanceMoved > MAX_ALLOWED_SPEED) {
            event.setCancelled(true); // Stop their movement
            getLogger().warning("Player " + player.getName() + " was flagged for speed!");
            player.sendMessage(ChatColor.RED + "Anti-Cheat: Please avoid speed hacks.");

            // Small knockback effect
            Vector knockback = from.toVector().subtract(to.toVector()).normalize().multiply(0.2);
            player.setVelocity(knockback);
        }
    }
}