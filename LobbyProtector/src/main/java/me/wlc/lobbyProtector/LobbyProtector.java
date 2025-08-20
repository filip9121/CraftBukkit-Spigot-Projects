package me.yourusername.lobbyprotector;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class LobbyProtector extends JavaPlugin implements Listener {

    private String lobbyWorldName = "world"; // def=world

    @Override
    public void onEnable() {
        // Register our events
        getServer().getPluginManager().registerEvents(this);
        getLogger().info("LobbyProtector enabled! Protecting world: " + lobbyWorldName);
    }

    @Override
    public void onDisable() {
        getLogger().info("LobbyProtector disabled!");
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        if (event.getBlock().getWorld().getName().equalsIgnoreCase(lobbyWorldName)) {
            // Cancel the event
            event.setCancelled(true);

            event.getPlayer().sendMessage("§cYou can't break blocks in the lobby!");
        }
    }


    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {

        if (event.getBlock().getWorld().getName().equalsIgnoreCase(lobbyWorldName)) {

            event.setCancelled(true);
            event.getPlayer().sendMessage("§cYou can't place blocks in the lobby!");
        }
    }
}