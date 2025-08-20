package me.wlc.wlcPlus;
import kotlin.PublishedApi;
import org.bukkit.entity.Player;
import org.bukkit.event.EventException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class WlcPlus extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("WlcPlus is enabled!");
        // OLD API =getServer().getPluginManager().registerEvents(this, this);
    getServer().getPluginManager().registerEvents(this); // call the class

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("WlcPlus has been disabled!"); // Console message
    }
    // "Call this method when a PlayerJoinEvent happens"
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // This code runs every time a player joins the server

        // Get the player who just joined from the event
        Player player = event.getPlayer();

        // Send a message to the player in their chat
        player.sendMessage("§aWelcome to the server! Enjoy your stay!");

        // (Optional) You can also change the global join message
        // event.setJoinMessage("§e" + player.getName() + " has joined the game!");
        player.sendMessage("Cheating is against the server rules!");
        player







    }
}