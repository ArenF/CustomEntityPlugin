package org.aren.customentityplugin;

import org.aren.command.PetCommandExecutor;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomEntityPlugin extends JavaPlugin {

    private static JavaPlugin plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        Bukkit.getPluginCommand("pet").setExecutor(new PetCommandExecutor());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static JavaPlugin getPlugin() {
        return plugin;
    }
}
