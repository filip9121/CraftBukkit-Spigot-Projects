// needs fixing (classes r mixed) 


package com.yourname.tpmanager.TPManager;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.HashMap;

public final class TPManager extends JavaPlugin {

    public HashMap<String, String> tpaRequests = new HashMap<>();

    @Override
    public void onEnable() {
        // Save the default config.yml if it doesn't exist
        saveDefaultConfig();

        // Register commands
        getCommand("tpa").setExecutor(new TpaCommand(this));
        getCommand("tpaccept").setExecutor(new TpAcceptCommand(this));
        getCommand("tpdeny").setExecutor(new TpDenyCommand(this));

        getLogger().info("TPManager has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("TPManager has been disabled!");
        tpaRequests.clear();
    }
}